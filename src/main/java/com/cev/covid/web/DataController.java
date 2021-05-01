package com.cev.covid.web;

import com.cev.covid.domain.Data;
import com.cev.covid.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {
	
	@Autowired
	private DataService dataService;

	@EventListener(ApplicationReadyEvent.class)
	public void parseDailyCovidData() {
		final var yesterday = LocalDate.now().minusDays(1);
		if(dataService.parseData(yesterday))
			System.out.println("Covid data parsed correctly!");
		else
			System.out.println("An error occurred parsing the data!");
	}
	
	@GetMapping("data")
	public List<Data> getCommunities(){
		return dataService.getData();
	}
	
	@GetMapping("dataRegion/{name}")
	public List<Data> getDataRegion(@PathVariable String name) {
		return dataService.getDataRegion(name);
	}
}
