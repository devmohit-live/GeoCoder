package com.mohit.assignment.GeoCoder.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.mohit.assignment.GeoCoder.exceptions.FileCreationException;
import com.mohit.assignment.GeoCoder.exceptions.InvalidPathException;
import com.mohit.assignment.GeoCoder.exceptions.ReadFileException;


@Component
public class FileStoreageService {

	
	Path fileStoragePath ;
	String location = "src/main/resources/files";
	
	@Autowired
	private GetCordinateService cordinateService;
	
	public FileStoreageService() {
		this.fileStoragePath= Paths.get(location);
		try {
			Files.createDirectories(fileStoragePath);
		}catch(Exception e) {
			System.out.println("Error in creating directories");
		}
	}




	public String storeFile(MultipartFile file) throws  ReadFileException, FileCreationException {
		String name = StringUtils.cleanPath(file.getOriginalFilename());
		
		Path inpPath = Paths.get(fileStoragePath+"\\"+name);
		Path outPath = Paths.get(fileStoragePath+"\\"+name+"-output");
		try {
			InputStream outStream = cordinateService.readFiles(inpPath);
			System.out.println(outStream.toString());
			Files.copy(file.getInputStream(), inpPath, StandardCopyOption.REPLACE_EXISTING);
			Files.copy(outStream, outPath, StandardCopyOption.REPLACE_EXISTING);
		}catch (ReadFileException | IOException e) {
			throw new FileCreationException("Invliad Path, File not Found");
		}finally {
			return name;
		}
	}




	public Resource download(String fileName) {
		Path path = Paths.get(location).toAbsolutePath().resolve(fileName);
		Path path2 = Paths.get(location).toAbsolutePath().resolve(fileName+"-output");
		Resource resource = null;
		try {	
			resource = new UrlResource(path2.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		if(resource!=null && resource.exists() && resource.isReadable()) return resource;
		else 
			throw new RuntimeException("Filer for download not present");
		
	}


}
