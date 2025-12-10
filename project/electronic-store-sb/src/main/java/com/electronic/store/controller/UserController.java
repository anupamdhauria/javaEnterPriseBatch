package com.electronic.store.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.electronic.store.dtos.ApiResponseMessage;
import com.electronic.store.dtos.FileResponse;
import com.electronic.store.dtos.PageableResponse;
import com.electronic.store.dtos.UserDto;
import com.electronic.store.services.FileService;
import com.electronic.store.services.UserService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {


	private Logger logger=LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@Autowired
	private FileService fileService;
	
	@Value("${user.file.upload.path}")
	private String fileUploadPath;

    

	// create
	@PostMapping
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto userDto1 = userService.createUser(userDto);
		return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
	}

	// update
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,
			@PathVariable("userId") String userId) {
		UserDto userDto1 = userService.updateUser(userDto, userId);
		return new ResponseEntity<>(userDto1, HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponseMessage> deleteUser(@PathVariable String userId) throws IOException {
		UserDto user = userService.getUserById(userId);
		String filePath=fileUploadPath+user.getImageName();
		Path path=Paths.get(filePath);
		Files.delete(path);
		
		userService.deleteUser(userId);
		ApiResponseMessage message = ApiResponseMessage.builder().message("User deleted Successfully!!").success(true)
				.status(HttpStatus.OK).build();
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	// get all users
	@GetMapping
	public ResponseEntity<PageableResponse<UserDto>> getAllUsers(
			@RequestParam(value="pageNumber",defaultValue = "0",required=false) int pageNumber,
			@RequestParam(value="pageSize",defaultValue ="5",required=false) int pageSize,
			@RequestParam(value="sortBy",defaultValue="name",required=false) String sortBy,
			@RequestParam(value="sortDir",defaultValue="asc",required=false) String sortDir) {
		PageableResponse<UserDto> users = userService.getAllUsers(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	// get single user by id
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("userId") String userID) {
		UserDto userById = userService.getUserById(userID);
		return new ResponseEntity<UserDto>(userById, HttpStatus.OK);

	}

	// get single user by email
	@GetMapping("/email/{emailid}")
	public ResponseEntity<UserDto> getUserByEmail(@PathVariable("emailid") String email) {
		UserDto userById = userService.getUserByEmail(email);
		return new ResponseEntity<UserDto>(userById, HttpStatus.OK);

	}

	// search user by Name containing keywords
	@GetMapping("/search/{keyword}")
	public ResponseEntity<List<UserDto>> searchUser(@PathVariable String keyword) {
		System.out.println(keyword);
		List<UserDto> searchUsers = userService.searchUser(keyword);
		return new ResponseEntity<>(searchUsers, HttpStatus.OK);
	}
	
	//upload a file for user
	@PostMapping("/image/{userid}")
	public ResponseEntity<FileResponse> uploadUserImage(@RequestParam("userImage")MultipartFile file,@PathVariable("userid") String userId) throws IOException{
		
		String fileName = fileService.uploadFile(file, fileUploadPath);
		logger.info("filename::{}",fileName);
		UserDto user = userService.getUserById(userId);
		user.setImageName(fileName);
		UserDto updateUser = userService.updateUser(user, userId);
		FileResponse response=FileResponse.builder()
				.fileName(fileName)
				.message("Image uploaded successfully")
				.status(HttpStatus.CREATED)
				.success(true)
				.build();
		
		
		return new ResponseEntity<>(response,HttpStatus.CREATED);
		
	}
	
	//fetch a file
	@GetMapping("/image/{userId}")
	public void fetchFile(@PathVariable String userId,HttpServletResponse response) throws IOException {
		UserDto user = userService.getUserById(userId);
		
		InputStream fetchImage = fileService.fetchImage(fileUploadPath,user.getImageName());
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(fetchImage, response.getOutputStream());
	}
	
}
