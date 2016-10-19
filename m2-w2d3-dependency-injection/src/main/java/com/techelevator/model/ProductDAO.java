package com.techelevator.model;

import java.util.List;

public interface ProductDAO {

	public List<Product> getAllProducts();
	public Product getProductById(Long id);
}
