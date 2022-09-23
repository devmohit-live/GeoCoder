package com.mohit.assignment.GeoCoder.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


@Component
public class FileStoreageService {

	
	Path fileStoragePath ;
	String location = "src/main/resources/files";
	
	@Autowired
	private FileOp fileop;
	
	public FileStoreageService() {
		this.fileStoragePath= Paths.get(location);
		try {
			Files.createDirectories(fileStoragePath);
		}catch(Exception e) {
			System.out.println("Error in creating directories");
		}
	}




	public String storeFile(MultipartFile file) {
		String name = StringUtils.cleanPath(file.getOriginalFilename());
		Path filePath = Paths.get(fileStoragePath+"\\"+name);
		try {
			InputStream inpStream = fileop.readFiles(filePath);
			Files.copy(inpStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}




	public Resource download(String fileName) {
		Path path = Paths.get(location).toAbsolutePath().resolve(fileName);
		Resource resource = null;
		try {	
			resource = new UrlResource(path.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		if(resource!=null && resource.exists() && resource.isReadable()) return resource;
		else 
			throw new RuntimeException("Filer for download not present");
		
	}


}
