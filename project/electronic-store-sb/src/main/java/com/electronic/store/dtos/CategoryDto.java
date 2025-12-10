package com.electronic.store.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CategoryDto {

	private String categoryId;
	
	@NotBlank(message="title is required!!")
	@Size(min=4,max=50,message="title must be between 4 and 50!!")
	private String title;
	
	@NotBlank
	private String description;
	
	@NotBlank
	private String coverImage;
}
