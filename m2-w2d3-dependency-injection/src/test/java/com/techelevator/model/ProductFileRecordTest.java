package com.techelevator.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProductFileRecordTest {

	@Test
	public void parses_product_id_from_record() {
		ProductFileRecord p = new ProductFileRecord("7|name|1");
		assertEquals(new Long(7), p.getId());
	}

	@Test
	public void parses_product_name_from_record() {
		ProductFileRecord p = new ProductFileRecord("7|Red Cabbage|1");
		assertEquals("Red Cabbage", p.getName());
	}

	@Test
	public void parses_product_price_from_record() {
		ProductFileRecord p = new ProductFileRecord("7|Red Cabbage|4");
		assertEquals(4, p.getPrice());
	}

}
