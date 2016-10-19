package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileSystemProductDAO implements ProductDAO {

	private ProductDataInputStreamProvider inputStreamProvider;

	@Autowired
	public FileSystemProductDAO(ProductDataInputStreamProvider inputStreamProvider) {
		this.inputStreamProvider = inputStreamProvider;
	}

	@Override
	public List<Product> getAllProducts() {
		ArrayList<Product> products = new ArrayList<>();
		try(Scanner productFileScanner = getProductFileScanner()) {
			while(productFileScanner.hasNextLine()) {
				ProductFileRecord record = new ProductFileRecord(productFileScanner.nextLine());
				Product p = new Product(record.getId(), record.getName(), record.getPrice());
				products.add(p);
			}
		}
		return products;
	}

	@Override
	public Product getProductById(Long id) {
		Product result = null;
		for(Product p : getAllProducts()) {
			if(p.getId().equals(id)) {
				result = p;
			}
		}
		return result;
	}
	
	private Scanner getProductFileScanner() {
		return new Scanner(inputStreamProvider.getInputStream());
	}
}
