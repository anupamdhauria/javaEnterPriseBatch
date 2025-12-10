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

import com.electronic.store.dtos.CategoryDto;
import com.electronic.store.dtos.PageableResponse;
import com.electronic.store.entities.Category;
import com.electronic.store.exceptions.ResourceNotFoundException;
import com.electronic.store.helper.Helper;
import com.electronic.store.repositories.CategoryRepository;
import com.electronic.store.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		String categoryID = UUID.randomUUID().toString();
		categoryDto.setCategoryId(categoryID);
		Category category = mapper.map(categoryDto, Category.class);
		categoryRepository.save(category);
		return mapper.map(category, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, String categoryId) {
			
		Category category = categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category not found on given id!!"));
		
		category.setTitle(categoryDto.getTitle());
		category.setDescription(categoryDto.getDescription());
		category.setCoverImage(categoryDto.getCoverImage());
		categoryRepository.save(category);
		return mapper.map(category, CategoryDto.class);
	}

	@Override
	public void deleteCategory(String categoryId) {
		Category category = categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category not found on given id!!"));
		categoryRepository.delete(category);
	}

	@Override
	public PageableResponse<CategoryDto> getAllCategory(int pageNumber,int pageSize,String sortBy,String sortDir) {
		Sort sort=(sortDir.equalsIgnoreCase("desc"))?(Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());
		Pageable pageable=PageRequest.of(pageNumber, pageSize,sort);
		Page<Category> page = categoryRepository.findAll(pageable);
		PageableResponse<CategoryDto> pageableResponse = Helper.getPageableResponse(page, CategoryDto.class);
		return pageableResponse;
	}

	@Override
	public CategoryDto getCategoryById(String categoryId) {
		Category category = categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category not found on given id!!"));
		return mapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> searchCategory(String keyword) {
		List<Category> categories = categoryRepository.findByTitleContaining(keyword);
		List<CategoryDto> catDtos = categories.stream().map(category->mapper.map(category, CategoryDto.class)).collect(Collectors.toList());
		return catDtos;
	}

}
