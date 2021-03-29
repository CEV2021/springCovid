package com.cev.covid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cev.covid.domain.Data;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {
	List<Data> findByRegion_Name(String name);
}
