package com.electronic.store.services;

import com.electronic.store.dtos.PageableResponse;
import com.electronic.store.dtos.ProductDto;

public interface ProductService {

	//create
	ProductDto create(ProductDto productDto);
	
	//update
	ProductDto update(ProductDto productDto,String productId);
	
	//delete
	void delete(String productId);
	
	//get single product
	ProductDto getProductById(String productId);
	
	//get all products
	PageableResponse<ProductDto> getAll(int pageNumber,int pageSize,String sortBy,String sortDir);
	
	//get all:live products
	PageableResponse<ProductDto>getAllLive(int pageNumber,int pageSize,String sortBy,String sortDir);

	//search products
	PageableResponse<ProductDto>searchByTitle(String subTitle,int pageNumber,int pageSize,String sortBy,String sortDir);
	
	
}
