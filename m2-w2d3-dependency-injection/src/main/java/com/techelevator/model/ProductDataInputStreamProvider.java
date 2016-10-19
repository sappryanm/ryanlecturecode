package com.techelevator.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductDataInputStreamProvider {
	
	private File productFile;

	@Autowired
	public ProductDataInputStreamProvider(@Value("classpath:products.csv") File productFile) {
		this.productFile = productFile;
	}
	
	public InputStream getInputStream() {
		try {
			return new FileInputStream(productFile);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("The product file ["+productFile+"] does not exist.", e );
		}
	}
}
