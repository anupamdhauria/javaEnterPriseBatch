package com.electronic.store.services.impl;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.electronic.store.dtos.ApiResponseMessage;
import com.electronic.store.dtos.PageableResponse;
import com.electronic.store.dtos.ProductDto;
import com.electronic.store.entities.Product;
import com.electronic.store.exceptions.ResourceNotFoundException;
import com.electronic.store.helper.Helper;
import com.electronic.store.repositories.ProductRepository;
import com.electronic.store.repositories.UserRepository;
import com.electronic.store.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private final UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper mapper;

    ProductServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
    
    //create
	@Override
	public ProductDto create(ProductDto productDto) {
		//generate unique id
		String productId=UUID.randomUUID().toString();
		productDto.setProductId(productId);
		
		//added date
		productDto.setAddedDate(new Date());
		Product product = mapper.map(productDto, Product.class);
		
		productRepository.save(product);
		return mapper.map(product, ProductDto.class);
	}

	//update
	@Override
	public ProductDto update(ProductDto productDto, String productId) {
		
		 Product product = productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product is not found in this Id!!"));
		
		 product.setDescription(productDto.getDescription());
		 product.setPrice(productDto.getPrice());
		 product.setDiscountedPrice(productDto.getDiscountedPrice());
		 product.setLive(productDto.isLive());
		 product.setQuantity(productDto.getQuantity());
		 product.setStock(productDto.isStock());
		 product.setTitle(productDto.getTitle());
		 product.setProductImage(productDto.getProductImage());
		 productRepository.save(product);
		 return mapper.map(product, ProductDto.class);
	}
	
	//delete
	@Override
	public void delete(String productId) {
		 Product product = productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product is not found in this Id!!"));
		 productRepository.delete(product);
	}
	
	//get single product
	@Override
	public ProductDto getProductById(String productId) {
		Product product = productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product is not found in this Id!!"));
		return mapper.map(product, ProductDto.class);
	}

	//get all products
	@Override
	public PageableResponse<ProductDto> getAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
		
		Sort sort=(sortDir.equalsIgnoreCase("desc"))?(Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());
		Pageable pageable=PageRequest.of(pageNumber, pageSize,sort);
		Page<Product> products = productRepository.findAll(pageable);
		PageableResponse<ProductDto> pageableResponse = Helper.getPageableResponse(products, ProductDto.class);
		return pageableResponse;
	}

	//get all live products
	@Override
	public PageableResponse<ProductDto> getAllLive(int pageNumber, int pageSize, String sortBy, String sortDir) {
		Sort sort=(sortDir.equalsIgnoreCase("desc"))?(Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());
		Pageable pageable=PageRequest.of(pageNumber, pageSize,sort);
		Page<Product> products = productRepository.findByLiveTrue(pageable);
		PageableResponse<ProductDto> pageableResponse = Helper.getPageableResponse(products, ProductDto.class);
		return pageableResponse;
	}

	//search product by title
	@Override
	public PageableResponse<ProductDto> searchByTitle(String subTitle, int pageNumber, int pageSize, String sortBy,
			String sortDir) {
		Sort sort=(sortDir.equalsIgnoreCase("desc"))?(Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());
		Pageable pageable=PageRequest.of(pageNumber, pageSize,sort);
		Page<Product> products = productRepository.findByTitleContaining(subTitle, pageable);
		PageableResponse<ProductDto> pageableResponse = Helper.getPageableResponse(products, ProductDto.class);
		return pageableResponse;
	}

}
