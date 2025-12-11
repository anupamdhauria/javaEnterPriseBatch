package com.electronic.store.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.StreamSupport;

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
import com.electronic.store.dtos.ImageResponse;
import com.electronic.store.dtos.PageableResponse;
import com.electronic.store.dtos.ProductDto;
import com.electronic.store.dtos.UserDto;
import com.electronic.store.services.FileService;
import com.electronic.store.services.ProductService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private FileService fileService;
	
	@Value("${product.file.upload.path}")
	private String imagePath;
	
	//create
	@PostMapping
	public ResponseEntity<ProductDto>createProduct(@Valid @RequestBody ProductDto productDto){
		
		ProductDto product = productService.create(productDto);
		return new ResponseEntity<>(product,HttpStatus.CREATED);
	}
	
	//update
	@PutMapping("/{productId}")
	public ResponseEntity<ProductDto>updateProduct(@Valid @RequestBody ProductDto productDto,@PathVariable String productId){
		
		ProductDto product = productService.create(productDto);
		return new ResponseEntity<>(product,HttpStatus.CREATED);
	}
	
	//delete
	@DeleteMapping("/{productId}")
	public ResponseEntity<ApiResponseMessage>deleteProduct(@PathVariable String productId) throws IOException{
		ProductDto productDto = productService.getProductById(productId);
		String path=imagePath+productDto.getProductImage();
		fileService.deleteFile(path);
		productService.delete(productId);
		ApiResponseMessage responseMessage = ApiResponseMessage.builder().message("product is deleted").status(HttpStatus.OK).success(true).build();
		return new ResponseEntity<>(responseMessage,HttpStatus.OK);
	}
	
	//get single product
	@GetMapping("/{productId}")
	public ResponseEntity<ProductDto>createProduct(@PathVariable String productId){
		
		ProductDto product = productService.getProductById(productId);
		return new ResponseEntity<>(product,HttpStatus.CREATED);
	}
	
	//get all product
	@GetMapping
	public ResponseEntity<PageableResponse<ProductDto>> getAllProducts(
			@RequestParam(value="pageNumber",defaultValue = "0",required=false) int pageNumber,
			@RequestParam(value="pageSize",defaultValue ="5",required=false) int pageSize,
			@RequestParam(value="sortBy",defaultValue="title",required=false) String sortBy,
			@RequestParam(value="sortDir",defaultValue="asc",required=false) String sortDir) {
		
		PageableResponse<ProductDto> response = productService.getAll(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	//get all live product
	@GetMapping("/live")
	public ResponseEntity<PageableResponse<ProductDto>> getAllLiveProducts(
			@RequestParam(value="pageNumber",defaultValue = "0",required=false) int pageNumber,
			@RequestParam(value="pageSize",defaultValue ="5",required=false) int pageSize,
			@RequestParam(value="sortBy",defaultValue="title",required=false) String sortBy,
			@RequestParam(value="sortDir",defaultValue="asc",required=false) String sortDir) {
		
		PageableResponse<ProductDto> response = productService.getAllLive(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	//search product by title
	@GetMapping("/search/{keywords}")
	public ResponseEntity<PageableResponse<ProductDto>> searchProducts(
			@PathVariable String keywords,
			@RequestParam(value="pageNumber",defaultValue = "0",required=false) int pageNumber,
			@RequestParam(value="pageSize",defaultValue ="5",required=false) int pageSize,
			@RequestParam(value="sortBy",defaultValue="title",required=false) String sortBy,
			@RequestParam(value="sortDir",defaultValue="asc",required=false) String sortDir) {
		
		PageableResponse<ProductDto> response = productService.searchByTitle(keywords,pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	//upload product image
	@PostMapping("/images/{productId}")
	public ResponseEntity<ImageResponse>uploadProductImage(
			@RequestParam("productImage") MultipartFile file,
			@PathVariable String productId
			) throws IOException
	{
			String fileName = fileService.uploadFile(file, imagePath);
			ProductDto productDto= productService.getProductById(productId);
			productDto.setProductImage(fileName);
			ProductDto updatedProduct = productService.update(productDto, productId);
			ImageResponse response = ImageResponse.builder().fileName(updatedProduct.getProductImage()).message("Product image uploaded successfully").status(HttpStatus.CREATED).success(true).build();
			return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	
	//serve product image
	@GetMapping("/images/{productId}")
	public void serveImage(@PathVariable String productId,HttpServletResponse response) throws IOException {
		ProductDto productDto = productService.getProductById(productId);
		InputStream fetchImage = fileService.fetchImage(imagePath, productDto.getProductImage());
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(fetchImage, response.getOutputStream());
	}
	
}
