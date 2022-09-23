package com.mohit.assignment.GeoCoder.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mohit.assignment.GeoCoder.dto.FileUploadResponse;
import com.mohit.assignment.GeoCoder.services.FileStoreageService;


@RestController
public class FileUploadDownloadController {

	@Autowired
	private FileStoreageService filestorage;
	
	@PostMapping("/upload-file")
	public FileUploadResponse fileUpload(@RequestParam("file") MultipartFile file){
		String filename = filestorage.storeFile(file);
		String url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/").path(filename).toUriString();
		FileUploadResponse response = new FileUploadResponse(filename,file.getContentType() ,url );
		return response;
	}
	
	@GetMapping("/download/{fileName}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName){
		
		Resource resource = filestorage.download(fileName);
		
		return ResponseEntity.ok().
				contentType(MediaType.TEXT_PLAIN).
				header(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName="+resource.getFilename()).body(resource);
		
	}
}
