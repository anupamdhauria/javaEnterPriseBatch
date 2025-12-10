package com.electronic.store.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
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
import com.electronic.store.dtos.CategoryDto;
import com.electronic.store.dtos.FileResponse;
import com.electronic.store.dtos.PageableResponse;
import com.electronic.store.services.CategoryService;
import com.electronic.store.services.FileService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private FileService fileService;
	
	@Value("${category.file.upload.path}")
	private String fileUploadPath;

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
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponseMessage>deleteUser(@PathVariable String categoryId) throws IOException{
		
		CategoryDto category = categoryService.getCategoryById(categoryId);
		String filePath=fileUploadPath+category.getCoverImage();
		fileService.deleteFile(filePath);
		
		categoryService.deleteCategory(categoryId);
		ApiResponseMessage response=ApiResponseMessage.builder().message("Category deleted Successfully!").status(HttpStatus.OK).success(true).build();
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
	//get all category
	@GetMapping
	public ResponseEntity<PageableResponse<CategoryDto>>getAllCategory(
			@RequestParam(value="pageNumber",required=false,defaultValue="0") int pageNumber,
			@RequestParam(value="pageSize",required=false,defaultValue="5") int pageSize,
			@RequestParam(value="sortBy",required=false,defaultValue="title") String sortBy,
			@RequestParam(value="sortDir",required=false,defaultValue="asc") String sortDir)
	{
		
		PageableResponse<CategoryDto> pageableResponse = categoryService.getAllCategory(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<>(pageableResponse,HttpStatus.OK);
		
	}
	
	
	
	//get single
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto>getCategoryById(@PathVariable String categoryId){
		CategoryDto category = categoryService.getCategoryById(categoryId);
		return ResponseEntity.ok(category);
	}
	
	//search by title
	@GetMapping("/search/{keyword}")
	public ResponseEntity<List<CategoryDto>>searchCategoryByTitle(@PathVariable String keyword){
		List<CategoryDto> categories = categoryService.searchCategory(keyword);
		return new ResponseEntity<>(categories,HttpStatus.OK);
	}
	
	//upload cover photo
	@PostMapping("/images/{categoryId}")
	public ResponseEntity<FileResponse> uploadCategoryPhoto(@RequestParam("categoryImage")MultipartFile file,@PathVariable String categoryId) throws IOException{
		String fileName = fileService.uploadFile(file, fileUploadPath);
		CategoryDto category = categoryService.getCategoryById(categoryId);
		category.setCoverImage(fileName);
		CategoryDto updateCategory = categoryService.updateCategory(category, categoryId);
		FileResponse response=FileResponse.builder()
				.fileName(fileName)
				.message("Cover Photo Uploaded Successfully!")
				.status(HttpStatus.CREATED)
				.success(true).build();
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	//fetch cover photo
	@GetMapping("/images/{categoryId}")
	public void fetchCategoryPhoto(@PathVariable String categoryId,HttpServletResponse response) throws IOException {
		CategoryDto category = categoryService.getCategoryById(categoryId);
		
		InputStream fetchImage = fileService.fetchImage(fileUploadPath,category.getCoverImage());
		StreamUtils.copy(fetchImage, response.getOutputStream());
		
	}
}
