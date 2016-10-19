package com.techelevator.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import com.techelevator.model.Product;
import com.techelevator.model.ShoppingCart;
import com.techelevator.model.TestProductDAO;

public class StoreControllerTest {

	private ModelMap model;
	private StoreController controller;
	private TestProductDAO productDAO;
	private static final Product SOME_PRODUCT = new Product(1L, "Beets", 1);
	
	@Before
	public void setup() {
		model = new ModelMap();
		productDAO = new TestProductDAO();
		productDAO.addProduct(SOME_PRODUCT);
		controller = new StoreController(productDAO);
	}
	
	@Test
	public void adds_ShoppingCart_to_model_when_first_product_is_added() {
		assertNull(model.get("shoppingCart")); //sanity check
		controller.addProductToCart(SOME_PRODUCT.getId(), 1, model);
		assertNotNull(model.get("shoppingCart"));
	}

	@Test
	public void more_than_one_product_gets_added_to_same_cart() {
		Product prod1 = new Product(1L, "product 1", 3);
		Product prod2 = new Product(2L, "product 2", 3);
		controller.addProductToCart(prod1.getId(), 1, model);
		controller.addProductToCart(prod2.getId(), 2, model);
		ShoppingCart cart = (ShoppingCart)model.get("shoppingCart");
		assertEquals(2, cart.getPurchases().size());
	}
	
	@Test
	public void redirects_to_view_cart_after_adding_product() {
		String view = controller.addProductToCart(SOME_PRODUCT.getId(), 1, model);
		assertEquals("redirect:/viewCart", view);
	}
}
