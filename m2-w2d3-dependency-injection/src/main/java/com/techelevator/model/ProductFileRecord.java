package com.techelevator.model;

public class ProductFileRecord {

	private Long id;
	private String name;
	private int price;

	public ProductFileRecord(String record) {
		String[] recordParts = record.split("\\|");
		this.id = Long.parseLong(recordParts[0]);
		this.name = recordParts[1];
		this.price = Integer.parseInt(recordParts[2]);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
}
