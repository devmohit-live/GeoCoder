package com.mohit.assignment.GeoCoder;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.mohit.assignment.GeoCoder.services.FileOp;


@SpringBootApplication
@EnableCaching
public class GeoCoderApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(GeoCoderApplication.class, args);
	}
	
}
	
