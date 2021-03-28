package com.cev.covid.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cev.covid.domain.Data;
import com.cev.covid.service.DataService;

@RestController
@RequestMapping("/api")
public class DataController {
	
	@Autowired
	private DataService dataService;

	@PostMapping("data")
	public Data postData(@RequestBody Data data) {
		return dataService.postData(data);
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
