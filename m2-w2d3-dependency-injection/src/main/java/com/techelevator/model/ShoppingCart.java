package com.techelevator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {

	private ArrayList<Purchase> purchases = new ArrayList<>();
	
	public List<Purchase> getPurchases() {
		return Collections.unmodifiableList(purchases);
	}
	
	public void addPurchase(Product p, int quantity) {
		purchases.add(new Purchase(p, quantity));
	}
	
	public int getTotal() {
		int total = 0;
		for(Purchase p : purchases) {
			total += p.getTotal();
		}
		return total;
	}
	
	public boolean isNoItems() {
		return purchases.isEmpty();
	}
}
