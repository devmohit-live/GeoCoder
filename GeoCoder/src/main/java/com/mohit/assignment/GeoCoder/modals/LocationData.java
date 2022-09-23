package com.mohit.assignment.GeoCoder.modals;

import java.util.Arrays;

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
	
	public Location getCorrectLocationCordinates() {
		if(locations.length > 0)
			return locations[0];
		return new Location();
	}

	@Override
	public String toString() {
		return "LocationData [locations=" + Arrays.toString(locations) + "]";
	}
	
}
