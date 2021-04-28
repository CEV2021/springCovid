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
	private String yesterdaysFileName;

	public boolean parseData() {

		// If date already exists in repo return false and don't parse
		if (dataRepository.findFirstByDate(LocalDate.now().minusDays(1)).isPresent())
			return false;

		Region region;

		updateYesterdaysFileName();

		CompletableFuture<Boolean> fileDownload = CompletableFuture.supplyAsync(() -> downloadYesterdaysFile(yesterdaysFileName));
		while (!fileDownload.isDone())
			System.out.print("Downloading file... ");

		try (Reader in = new FileReader("./covid_19_daily_reports/" + yesterdaysFileName)) {
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().parse(in);
			for (CSVRecord record : records) {
				csvRecord = record;
				if (record.get("Country_Region").equals("Spain") && !record.get("Province_State").equals("Unknown")) {
					String regionName = record.get("Province_State");
					long confirmed = Long.parseLong(getRecordValueOrElseZero("Confirmed"));
					long deaths = Long.parseLong(getRecordValueOrElseZero("Deaths"));
					long recovered = Long.parseLong(getRecordValueOrElseZero("Recovered"));
					long active = Long.parseLong(getRecordValueOrElseZero("Active"));
					double incidentRate = Double.parseDouble(getRecordValueOrElseZero("Incident_Rate"));
					double caseFatalityRatio = Double.parseDouble(getRecordValueOrElseZero("Case_Fatality_Ratio"));
					// Instantiate current record
					Data currentRecord = new Data(LocalDate.now().minusDays(1), confirmed, deaths, recovered, active, incidentRate, caseFatalityRatio);
					// If subregion exists get it from repo, otherwise create it
					region = regionService.findByName(regionName).orElse(new Region(regionName));
					regionService.save(region);
					currentRecord.setRegion(region);
					dataRepository.save(currentRecord);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	private void updateYesterdaysFileName() {
		yesterdaysFileName = DateTimeFormatter.ofPattern("MM-dd-yyyy").format(LocalDate.now().minusDays(1)) + ".csv";
	}

	private Boolean downloadYesterdaysFile(String fileName) {
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
		String record = csvRecord.get(header);
		return record.isEmpty() ? "0" : record;
	}

	public Data findYesterdaysTotalNumbers() {
		System.out.println("ataRepository.findYesterdaysTotalNumbers().orElse(new Data() = " + dataRepository.findYesterdaysTotalNumbers().orElse(new Data()));
		final var data = dataRepository.findYesterdaysTotalNumbers().orElse(new Data());
		return data;
	}
}
