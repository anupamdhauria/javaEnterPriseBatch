package com.electronic.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electronic.store.dtos.ApiResponseMessage;
import com.electronic.store.dtos.UserDto;
import com.electronic.store.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	//create
	@PostMapping
	public ResponseEntity<UserDto> createUser (@Valid @RequestBody UserDto userDto){
		UserDto userDto1=userService.createUser(userDto);
		return new ResponseEntity<>(userDto1,HttpStatus.CREATED);
	}
	
	//update
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser (@Valid @RequestBody UserDto userDto,@PathVariable("userId")String userId)
	{
		UserDto userDto1=userService.updateUser(userDto,userId);
		return new ResponseEntity<>(userDto1,HttpStatus.OK);
	}
	
	//delete
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponseMessage>deleteUser(@PathVariable String userId){
		userService.deleteUser(userId);
		ApiResponseMessage message= ApiResponseMessage
				.builder()
				.message("User deleted Successfully!!")
				.success(true)
				.status(HttpStatus.OK).build();
		return new ResponseEntity<>(message,HttpStatus.OK);
	}
	
	//get all users
	@GetMapping
	public ResponseEntity<List<UserDto>>getAllUsers(){
		List<UserDto> users = userService.getAllUsers();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	//get single user by id
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto>getUserById(@PathVariable("userId")String userID){
		UserDto userById = userService.getUserById(userID);
		return new ResponseEntity<UserDto>(userById,HttpStatus.OK);
		
	}
	
	//get single user by email
	@GetMapping("/email/{emailid}")
	public ResponseEntity<UserDto>getUserByEmail(@PathVariable("emailid")String email){
		UserDto userById = userService.getUserByEmail(email);
		return new ResponseEntity<UserDto>(userById,HttpStatus.OK);
		
	}
	
	//search user by Name containing keywords	
	@GetMapping("/search/{keyword}")
	public ResponseEntity<List<UserDto>>searchUser(@PathVariable String keyword){
		System.out.println(keyword);
		List<UserDto> searchUsers = userService.searchUser(keyword);
		return new ResponseEntity<>(searchUsers,HttpStatus.OK);
	}
}
