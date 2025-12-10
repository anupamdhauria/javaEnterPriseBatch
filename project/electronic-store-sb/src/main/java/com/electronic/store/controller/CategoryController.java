package com.electronic.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electronic.store.dtos.CategoryDto;
import com.electronic.store.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	//create
	@PostMapping
	public ResponseEntity<CategoryDto>createUser(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto category = categoryService.createCategory(categoryDto);
		return new ResponseEntity<>(category,HttpStatus.CREATED);
	}
	
	//update
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto>updateUser(@Valid @RequestBody CategoryDto categoryDto,@PathVariable String categoryId){
		CategoryDto category = categoryService.updateCategory(categoryDto, categoryId);
		return new ResponseEntity<>(category,HttpStatus.OK);
	}
	
	//delete
	
	
	
	//get all 
	
	
	//get single
	
	
	//search by title
}
