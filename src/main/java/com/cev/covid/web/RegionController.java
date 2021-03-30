package com.cev.covid.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cev.covid.domain.Region;
import com.cev.covid.service.RegionService;
import com.cev.covid.web.errors.NotFoundException;

@RestController
@RequestMapping("/api")
public class RegionController {

	@Autowired
    private RegionService regionService;

	@GetMapping("/regions")
	public List<Region> getRegions(){
		return regionService.getRegions();
	}
	
	@GetMapping("/regions/{name}")
	public Region getRegionName(@PathVariable String name) {
		return regionService.findByName(name).orElse(new Region());
	}
}
