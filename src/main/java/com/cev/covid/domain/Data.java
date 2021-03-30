package com.cev.covid.domain;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Data {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private LocalDate date;
	private long confirmed;
	private long deaths;
	private long recovered;
	private long active;
	private double incidentRate;
	private double caseFatalityRatio;
	
	@ManyToOne
	@JsonIgnoreProperties({"data"})
	private Region region;

	public Data() {}

	public Data(LocalDate date, long confirmed, long deaths, long recovered, long active, double incidentRate, double caseFatalityRatio) {
		this.date = date;
		this.confirmed = confirmed;
		this.deaths = deaths;
		this.recovered = recovered;
		this.active = active;
		this.incidentRate = incidentRate;
		this.caseFatalityRatio = caseFatalityRatio;
	}
	
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public long getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(long confirmed) {
		this.confirmed = confirmed;
	}
	public long getDeaths() {
		return deaths;
	}
	public void setDeaths(long deaths) {
		this.deaths = deaths;
	}
	public long getRecovered() {
		return recovered;
	}
	public void setRecovered(long recovered) {
		this.recovered = recovered;
	}
	public long getActive() {
		return active;
	}
	public void setActive(long active) {
		this.active = active;
	}
	public double getIncidentRate() {
		return incidentRate;
	}
	public void setIncidentRate(double incidentRate) {
		this.incidentRate = incidentRate;
	}
	public double getCaseFatalityRatio() {
		return caseFatalityRatio;
	}
	public void setCaseFatalityRatio(double caseFatalityRatio) {
		this.caseFatalityRatio = caseFatalityRatio;
	}
	
}
