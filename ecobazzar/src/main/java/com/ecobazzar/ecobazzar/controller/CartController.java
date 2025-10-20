package com.ecobazzar.ecobazzar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecobazzar.ecobazzar.dto.CartSummaryDto;
import com.ecobazzar.ecobazzar.model.CartItem;
import com.ecobazzar.ecobazzar.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	
	private final CartService cartService;
	
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}
	
	@PostMapping
	public CartItem addToCart(@RequestBody CartItem cartItem) {
		return cartService.addToCart(cartItem);
	}
	
	@GetMapping("/{userId}")
	public CartSummaryDto getCartSummary(@PathVariable Long userId) {
		return cartService.getCartSummary(userId);
	}
	
	@DeleteMapping("/{id}")
	public String removeFromCart(@PathVariable Long id) {
		cartService.removeFromCart(id);
		return "Item Removed from Cart!";
	}
	

}
