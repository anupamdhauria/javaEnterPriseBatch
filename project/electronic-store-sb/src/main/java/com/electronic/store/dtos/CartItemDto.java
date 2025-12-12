package com.electronic.store.dtos;

import com.electronic.store.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemDto {
	
	private int cartItemId;	
	private int quantity;	
	private Product product;	
	private double totalPrice;	
}
