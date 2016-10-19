package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.Product;
import com.techelevator.model.ProductDAO;
import com.techelevator.model.ShoppingCart;

@Controller 
@SessionAttributes("shoppingCart")
public class StoreController {

	private ProductDAO productDAO;
	
	@Autowired
	public StoreController(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	@RequestMapping(path={"/", "productList"}, method=RequestMethod.GET)
	public String displayProductList(ModelMap model) {
		model.put("products", productDAO.getAllProducts());
		return "productList";
	}
	
	@RequestMapping(path="/productDetail", method=RequestMethod.GET)
	public String displayProductDetail(@RequestParam Long productId, 
									  ModelMap model) {
		model.put("product", productDAO.getProductById(productId));
		return "productDetail";
	}
	
	@RequestMapping(path="/addToCart", method=RequestMethod.POST)
	public String addProductToCart(@RequestParam Long productId,
								  @RequestParam int quantity,
								  ModelMap model) {
		
		ShoppingCart cart = getShoppingCart(model);
		Product theProduct = productDAO.getProductById(productId);
		cart.addPurchase(theProduct, quantity);
		return "redirect:/viewCart";
	}
	
	@RequestMapping(path="/viewCart", method=RequestMethod.GET)
	public String displayShoppingCartContents() {
		return "viewCart";
	}

	private ShoppingCart getShoppingCart(ModelMap model) {
		ShoppingCart cart = (ShoppingCart)model.get("shoppingCart");
		if(cart == null) {
			cart = new ShoppingCart();
			model.put("shoppingCart", cart);
		}
		return cart;
	}
}
