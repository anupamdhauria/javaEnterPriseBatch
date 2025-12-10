package com.electronic.store.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.electronic.store.dtos.ApiResponseMessage;
import com.electronic.store.dtos.FileResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	//handle resource not found exception
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponseMessage>handleResourceNotFoundException(ResourceNotFoundException ex){
		
		ApiResponseMessage message = ApiResponseMessage.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).success(true).build();
		return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
	}

	//handling api exception
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		Map<String, Object> response = new HashMap<>();
		Map<String, String> fieldErrors = new HashMap<>();

		ex.getBindingResult().getFieldErrors().forEach(error -> {
			fieldErrors.put(error.getField(), error.getDefaultMessage());
		});
		response.put("timestamp", LocalDateTime.now());
		response.put("status", HttpStatus.BAD_REQUEST.value());
		response.put("error", "Validation Failed");
		response.put("message", fieldErrors);
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

	}
	
	//handle bad request api
		@ExceptionHandler(BadApiRequestException.class)
		public ResponseEntity<ApiResponseMessage>handleBadApiResponseException(BadApiRequestException ex){
			
			ApiResponseMessage message = ApiResponseMessage.builder()
					.message(ex.getMessage())
					.status(HttpStatus.BAD_REQUEST)
					.success(false).build();
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
}
