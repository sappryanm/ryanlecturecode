package com.techelevator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestProductDAO implements ProductDAO {

	private List<Product> productList = new ArrayList<>();
	
	@Override
	public List<Product> getAllProducts() {
		return Collections.unmodifiableList(productList);
	}

	@Override
	public Product getProductById(Long id) {
		Product result = null;
		for(Product p : productList) {
			if(p.getId().equals(id)) {
				result = p;
				break;
			}
		}
		return result;
	}

	public void addProduct(Product product) {
		productList.add(product);
	}
}
