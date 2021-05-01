package com.cev.covid.service;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.cev.covid.domain.Region;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cev.covid.domain.Data;
import com.cev.covid.repository.DataRepository;

@Service
public class DataService {

	@Autowired
	private DataRepository dataRepository;
	@Autowired
	private RegionService regionService;

	public Data postData(Data data) {
		return dataRepository.save(data);
	}

	public List<Data> getData(){
		return dataRepository.findAll();
	}

	public List<Data> getDataRegion(String name){
		return dataRepository.findByRegion_Name(name);
	}

	private CSVRecord csvRecord;
	private String fileName;

	public boolean parseData(LocalDate date) {
		// If date already exists in repo return false and don't parse
		if (dataRepository.findFirstByDate(date).isPresent())
			return false;

		updateFileName(date);

		CompletableFuture<Boolean> fileDownload = CompletableFuture.supplyAsync(() -> downloadCsvFile(fileName));
		while (!fileDownload.isDone())
			System.out.print("Downloading file... ");

		try (Reader in = new FileReader("./covid_19_daily_reports/" + fileName)) {
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().parse(in);
			for (CSVRecord record : records) {
				csvRecord = record;
				if (record.get("Country_Region").equals("Spain") && !record.get("Province_State").equals("Unknown")) {
					String regionName = record.get("Province_State");
					final var confirmed = Long.parseLong(getRecordValueOrElseZero("Confirmed"));
					final var deaths = Long.parseLong(getRecordValueOrElseZero("Deaths"));
					final var recovered = Long.parseLong(getRecordValueOrElseZero("Recovered"));
					final var active = Long.parseLong(getRecordValueOrElseZero("Active"));
					final var incidentRate = Double.parseDouble(getRecordValueOrElseZero("Incident_Rate"));
					final var caseFatalityRatio = Double.parseDouble(getRecordValueOrElseZero("Case_Fatality_Ratio"));
					// Instantiate current record
					final var currentRecord = new Data(LocalDate.now().minusDays(1), confirmed, deaths, recovered, active, incidentRate, caseFatalityRatio);
					// If subregion exists get it from repo, otherwise create it
					var region = regionService.findByName(regionName).orElse(new Region(regionName));
					regionService.save(region);
					currentRecord.setRegion(region);
					dataRepository.save(currentRecord);
				}
			}
			updateSpainTotalNumbers(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	private void updateSpainTotalNumbers(LocalDate date) {
		final var spainTotalNumbers = findSpainTotalNumbers(date);
		final var region = regionService.findByName("Spain").get();
		spainTotalNumbers.setRegion(region);
		dataRepository.save(spainTotalNumbers);
	}

	private void updateFileName(LocalDate date) {
		fileName = DateTimeFormatter.ofPattern("MM-dd-yyyy").format(date) + ".csv";
	}

	private Boolean downloadCsvFile(String fileName) {
		try {
			FileUtils.copyURLToFile(new URL("https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/" + fileName),
					new File("./covid_19_daily_reports/" + fileName));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private String getRecordValueOrElseZero(String header) {
		final var record = csvRecord.get(header);
		return record.isEmpty() ? "0" : record;
	}

	public Data findSpainTotalNumbers(LocalDate date) {
		return dataRepository.findYesterdaysTotalNumbers(date).orElse(new Data());
	}
}
