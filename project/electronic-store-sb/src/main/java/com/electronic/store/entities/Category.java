package com.electronic.store.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Entity
public class Category {

	@Id
	@Column(name = "id")
	private String categoryId;
	
	@Column(name="title",length=100,unique = true)
	private String title;
	
	@Column(name="description",length=500,nullable=false)
	private String description;
	
	@Column(name="category_image")
	private String coverImage;
	
}
