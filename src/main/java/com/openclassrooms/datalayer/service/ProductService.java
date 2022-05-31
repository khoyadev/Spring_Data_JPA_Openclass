package com.openclassrooms.datalayer.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.datalayer.model.Product;
import com.openclassrooms.datalayer.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public Iterable<Product> getProducts(){
		return productRepository.findAll();
	}

	public Optional<Product> getProductById(Integer id){
		return productRepository.findById(id);
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	} 
	
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}
	
	public Iterable<Product> getProductsByName(String name) {
		return productRepository.findByName(name);
	}
	
	public Iterable<Product> getProductByCategoriesName(String name){
		return productRepository.findByCategoriesName(name);
	}
	
	public Iterable<Product> getcostProduct(Integer cost){
		return productRepository.findByCostLessThan(cost);
	}
}
