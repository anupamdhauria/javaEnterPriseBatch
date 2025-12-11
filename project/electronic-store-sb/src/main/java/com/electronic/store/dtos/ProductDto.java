package com.electronic.store.dtos;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDto {

	private String productId;
	
	@NotBlank
	@Size(min=4,max=50,message="title should be in between 4 and 50")
	private String title;
	
	@NotBlank(message="description is required!!")
	private String description;
	
	@PositiveOrZero(message="price should be >= zero")
	private double price;
	
	@PositiveOrZero(message="discountedPrice should be >= zero")
	private double discountedPrice;
	
	@PositiveOrZero(message="quantity should be >= zero")
	private int quantity;
	
	private Date addedDate;
	
	private boolean live;
	
	private boolean stock;
	
	private String productImage;
}
