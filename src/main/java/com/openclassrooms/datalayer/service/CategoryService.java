package com.openclassrooms.datalayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.datalayer.model.Category;
import com.openclassrooms.datalayer.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	public Iterable<Category> getCategories(){
		return categoryRepository.findAll();
	}
	
	public Optional<Category> getCategoryById(Integer id){
		return categoryRepository.findById(id);
	}
	
	public Category saveCategorie(Category category) {
		
		return categoryRepository.save(category);
	}
	
	public void deleteCategorie(int id) {
		categoryRepository.deleteById(id);
	}

	public Iterable<Category> getCategoriesfindByName(String name){
		return categoryRepository.findByName(name);
	}
	public Iterable<Category> getCategoryByProductName(String name){
		return categoryRepository.findByProductsName(name);
	}
}
