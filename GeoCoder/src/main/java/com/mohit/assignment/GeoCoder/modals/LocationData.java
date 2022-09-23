package com.mohit.assignment.GeoCoder.modals;

import org.springframework.cache.annotation.Cacheable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationData {
	@JsonProperty("data")
	private Location[] locations ;

	public Location[] getLocations() {
		return locations;
	}

	public void setLocations(Location[] locations) {
		this.locations = locations;
	}
	
	@Cacheable(cacheNames = "location", key="#name")
	public Location getCorrectLocationCordinates() {
		return locations[0];
	}
	
}
