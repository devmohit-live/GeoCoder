package com.mohit.assignment.GeoCoder.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mohit.assignment.GeoCoder.exceptions.ReadFileException;
import com.mohit.assignment.GeoCoder.modals.Location;
@Service
public class GetCordinateService {
	
	
	public InputStream readFiles(Path path) throws ReadFileException {
		try {
			List<String> list = Files.lines(path).map(el-> getLocation(el))
				      .map(el->el.getLatitude()+", "+el.getLongitude())
				      .collect(Collectors.toList());
			StringBuilder sb = new StringBuilder();
			for(String s: list) sb.append(s+"\n");
			
			System.out.println(sb.toString());
			return new ByteArrayInputStream(sb.toString().getBytes());
		 
		} catch (IOException ex) {
			throw new ReadFileException("Invalid Path");
		}
	}

	public Location getLocation(String el) {
		String uri = "http://localhost:8080/getData?location=".concat(el);
		
		ResponseEntity<Location> responseEntity = new RestTemplate().getForEntity(uri, Location.class);
		
		return responseEntity.getBody();
	}
}
