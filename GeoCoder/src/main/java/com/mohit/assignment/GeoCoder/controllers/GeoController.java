package com.mohit.assignment.GeoCoder.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.mohit.assignment.GeoCoder.modals.Location;
import com.mohit.assignment.GeoCoder.modals.LocationData;

@RestController
public class GeoController {

	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final String API_KEY = "0d6b94b786955ce34b16bc531bcdacde";
	
	@GetMapping("/test")
	public String test() {
		return "serviceup";
	}
	
	@Cacheable("location") //based on loaction as key key cache the data
	@GetMapping("/getData")
	public Location getLocationData(@RequestParam String location) {
		
		UriComponents uri =  UriComponentsBuilder.newInstance()
				.scheme("http").host("api.positionstack.com")
		.path("/v1/forward").queryParam("access_key", API_KEY)
		.queryParam("query",location).build();
		logger.info("uri is {}", uri.toUriString());
		
		ResponseEntity<LocationData> responseEntity = new RestTemplate().getForEntity(uri.toUriString(), LocationData.class);
		LocationData locationData =  responseEntity.getBody();
//		System.out.println(locationData);
		return locationData.getCorrectLocationCordinates();
	}

}
