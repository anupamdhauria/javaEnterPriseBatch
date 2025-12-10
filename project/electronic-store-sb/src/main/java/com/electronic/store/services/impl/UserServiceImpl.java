package com.electronic.store.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.electronic.store.dtos.PageableResponse;
import com.electronic.store.dtos.UserDto;
import com.electronic.store.entities.User;
import com.electronic.store.exceptions.ResourceNotFoundException;
import com.electronic.store.helper.Helper;
import com.electronic.store.repositories.UserRepository;
import com.electronic.store.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		//generate unique id in string format
		String userId=UUID.randomUUID().toString();
		userDto.setUserId(userId);
		
		//dto->entity
		User user=dtoToEntity(userDto);
		User savedUser=userRepository.save(user);
		//enitity->dto
		UserDto newDto=entityToDto(savedUser);
		
		return newDto;
	}

	@Override
	public UserDto updateUser(UserDto userDto, String userId) {
		User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found on this ID"));
		
		user.setName(userDto.getName());
		user.setGender(userDto.getGender());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		user.setImageName(userDto.getImageName());
		
		userRepository.save(user);
		return entityToDto(user);
	}

	@Override
	public void deleteUser(String userId) {
		User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found on this Id"));
		userRepository.delete(user);
		
		
	}
	
	@Override
	public PageableResponse<UserDto> getAllUsers(int pageNumber,int pageSize,String sortBy,String sortDir){
		Sort sort=(sortDir.equalsIgnoreCase("desc")?(Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending()));
		Pageable pageable=PageRequest.of(pageNumber, pageSize,sort); 
		Page<User> pages = userRepository.findAll(pageable);
		PageableResponse<UserDto> response=Helper.getPageableResponse(pages, UserDto.class);
		
		return response;
	}

	@Override
	public UserDto getUserById(String userId) {
		User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found on this ID"));
		return entityToDto(user);
	}

	@Override
	public UserDto getUserByEmail(String email) {
		User user = userRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("User not found on this Email ID"));
		return entityToDto(user);
	}

	@Override
	public List<UserDto> searchUser(String keyword) {
		
		List<User> users = userRepository.findByNameContaining(keyword);
		List<UserDto> userDtos = users.stream().map(user->entityToDto(user)).collect(Collectors.toList());
		return userDtos;
	}
	
	
	//dto to entity object
	private User dtoToEntity(UserDto userDto) {
		/*
		 * return User.builder().userId(userDto.getUserId()) .email(userDto.getEmail())
		 * .about(userDto.getAbout()) .gender(userDto.getGender())
		 * .name(userDto.getName()) .password(userDto.getPassword())
		 * .imageName(userDto.getImageName()).build();
		 */
		return mapper.map(userDto, User.class);	
	}

	//entity to dto object
	private UserDto entityToDto(User savedUser) {
		/*
		 * return UserDto.builder().userId(savedUser.getUserId())
		 * .email(savedUser.getEmail()) .about(savedUser.getAbout())
		 * .gender(savedUser.getGender()) .name(savedUser.getName())
		 * .password(savedUser.getPassword())
		 * .imageName(savedUser.getImageName()).build();
		 */
		return mapper.map(savedUser, UserDto.class);
	}
}
