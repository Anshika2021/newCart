package com.retailApp.CartService.CartServices;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.retailApp.CartService.Pojo.CartItem;
import com.retailApp.CartService.Pojo.CartItemWrapper;


public interface CartItemsService {

	ResponseEntity<String> addToCart(Map<String, String> requestMap);

	ResponseEntity<List<CartItem>> getAll();

	ResponseEntity<List<CartItemWrapper>> getUserCart(Integer userId);

	ResponseEntity<Integer> deleteCartItem(Integer id);
	
	Integer updateQuantity (List<CartItem> product);


//	ResponseEntity<String> deleteAllByUserId(Integer userId);

}
