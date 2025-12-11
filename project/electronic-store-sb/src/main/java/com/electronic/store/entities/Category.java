package com.electronic.store.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="category")
	private List<Product>products=new ArrayList<>();
	
}
