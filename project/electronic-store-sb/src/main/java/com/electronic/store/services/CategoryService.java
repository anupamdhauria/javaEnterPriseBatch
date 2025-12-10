package com.electronic.store.services;

import java.util.List;

import com.electronic.store.dtos.CategoryDto;
import com.electronic.store.dtos.PageableResponse;

public interface CategoryService {

	//create
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	public CategoryDto updateCategory(CategoryDto categoryDto,String categoryId);

	//delete
	public void deleteCategory(String categoryId);
	
	//getAll
	public PageableResponse<CategoryDto>getAllCategory(int pageNumber,int pageSize,String sortBy,String sortDir);
	
	//get Single
	public CategoryDto getCategoryById(String categoryId);
	
	//search By Title
	public List<CategoryDto>searchCategory(String keyword);
	
}
