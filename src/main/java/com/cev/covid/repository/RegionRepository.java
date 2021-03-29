package com.cev.covid.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cev.covid.domain.Region;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
	Optional<Region> findByName(String name);
}
