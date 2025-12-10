package com.electronic.store.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	public String uploadFile(MultipartFile file,String path) throws IOException;
	
	public InputStream fetchImage(String path,String name) throws FileNotFoundException;
}
