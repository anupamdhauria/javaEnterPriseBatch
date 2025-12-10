package com.electronic.store.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electronic.store.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, String>{

	List<Category>findByTitleContaining(String keywords);
}
