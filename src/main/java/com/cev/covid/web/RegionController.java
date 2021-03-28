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

	@PostMapping("regions")
	public Region postRegion(@RequestBody Region region) {
		return regionService.postRegion(region);
	}

	@GetMapping("regions")
	public List<Region> getRegions(){
		return regionService.getRegions();
	}
	
	@GetMapping("region/{name}")
	public Region getRegionName(@PathVariable(name="name")String name) {
		Optional<Region> result = regionService.getRegion(name);
		if(result.isPresent()) {
			return result.get();
		}else {
			throw new NotFoundException("La comunidad " + name + " no existe");
		}
	}
}
