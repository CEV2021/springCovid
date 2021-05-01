package com.cev.covid.service;

import com.cev.covid.domain.Region;
import com.cev.covid.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {
	
	@Autowired
	private RegionRepository regionRepository;

	public Region postRegion(Region region) {
		return regionRepository.save(region);
	}
	
	public List<Region> getRegions(){
		return regionRepository.findAll();
	}

    public Optional<Region> findByName(String regionName) {
		return regionRepository.findByName(regionName);
    }

	public void save(Region region) {
		regionRepository.save(region);
	}
}
