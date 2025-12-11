package com.electronic.store.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.electronic.store.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

	//search by title
	Page<Product>findByTitleContaining(String subTitle,Pageable pageable);
	
	//search live product
	Page<Product>findByLiveTrue(Pageable pageable);
}
