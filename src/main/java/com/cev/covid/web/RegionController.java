package com.cev.covid.web;

import com.cev.covid.domain.Region;
import com.cev.covid.service.DataService;
import com.cev.covid.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RegionController {

	@Autowired
    private RegionService regionService;
	@Autowired
	private DataService dataService;

	@GetMapping("/regions")
	public List<Region> getRegions(){
		return regionService.getRegions();
	}
	
	@GetMapping("/regions/{name}")
	public Region getRegionName(@PathVariable String name) {
		return regionService.findByName(name).orElse(new Region());
	}
}
