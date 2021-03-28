package com.cev.covid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cev.covid.domain.Data;
import com.cev.covid.repository.DataRepository;

@Service
public class DataService {
	
	@Autowired
	private DataRepository dataRepository;

	public Data postData(Data data) {
		return dataRepository.save(data);
	}

	public List<Data> getData(){
		return dataRepository.findAll();
	}
	
	public List<Data> getDataRegion(String name){
		return dataRepository.findByRegion_Name(name);
	}
}
