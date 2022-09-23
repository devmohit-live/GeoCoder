package com.mohit.assignment.GeoCoder.modals;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
	private double latitude;
	private double longitude;
	@JsonProperty("county")
	private String name;
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Location [latitude=" + latitude + ", longitude=" + longitude + ", name=" + name + "]";
	}
	
	
}
