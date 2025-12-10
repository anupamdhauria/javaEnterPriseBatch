package com.electronic.store.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.electronic.store.exceptions.BadApiRequestException;
import com.electronic.store.services.FileService;


@Service
public class FileServiceImpl implements FileService {
	
	private Logger logger=LoggerFactory.getLogger(FileServiceImpl.class);

	@Override
	public String uploadFile(MultipartFile file, String path) throws IOException {
		String originalFilename = file.getOriginalFilename();
		String fileName=UUID.randomUUID().toString();
		String extension=originalFilename.substring(originalFilename.lastIndexOf("."));
		String fileNameWithExtension=fileName+extension;
		String fullPathWithFileName=path+fileNameWithExtension;
		
		if(extension.equalsIgnoreCase(".png")||extension.equalsIgnoreCase(".jpg")||extension.equalsIgnoreCase(".jpeg")) {
			File folder=new File(path);
			if(!folder.exists()) {
				folder.mkdirs();
			}
			//upload
			Files.copy(file.getInputStream(), Paths.get(fullPathWithFileName));
			logger.info("fileNameWithExtension::"+fileNameWithExtension);
			return fileNameWithExtension;
		}else {
			throw new BadApiRequestException("File with "+extension+" extension is not allowed!!");
		}
		
	}

	@Override
	public InputStream fetchImage(String path, String name) throws FileNotFoundException {
		
		String fullPathWithFileName=path+File.separator+name;
		InputStream inputStream = new FileInputStream(fullPathWithFileName);
		return inputStream;
		

	}

	@Override
	public void deleteFile(String filePath) throws IOException {
		Path path=Paths.get(filePath);
		Files.delete(path);
		
	}

}
