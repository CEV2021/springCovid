package com.cev.covid.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cev.covid.domain.Data;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {
	List<Data> findByRegion_Name(String name);

    Optional<Data> findFirstByDate(LocalDate date);

    @Query(value = "SELECT 0 AS id, CURDATE() - INTERVAL 1 DAY AS date, SUM(d.confirmed) AS confirmed, SUM(d.deaths) AS deaths, SUM(d.recovered) AS recovered, SUM(d.active) AS active, ROUND(SUM(d.incident_rate) / 19, 2) AS incident_rate, ROUND(SUM(d.case_fatality_ratio) / 19, 2) AS case_fatality_ratio, 20 AS region_id FROM data d " +
            "WHERE d.date = CURDATE() - INTERVAL 1 DAY",
            nativeQuery = true)
    Optional<Data> findYesterdaysTotalNumbers();
}
