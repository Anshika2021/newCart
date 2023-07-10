package com.retailApp.CartService.CartServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.retailApp.CartService.Pojo.CartItem;
import com.retailApp.CartService.Pojo.CartItemWrapper;
import com.retailApp.CartService.Repository.CartDao;

@Service
public class CartItemsServiceImpl implements CartItemsService {
	
	

   
	@Autowired
	CartDao cartDao;


	@Override
	public ResponseEntity<String> addToCart(Map<String,String>requestMap) {
		
		System.out.println(requestMap);

		
		CartItemWrapper cart= cartDao.findInCart(Integer.parseInt(requestMap.get("prod_id")),Integer.parseInt(requestMap.get("userId")));
		if(Objects.isNull(cart))
		{
			System.out.println(requestMap.get("prod_name"));
			System.out.println(Integer.parseInt(requestMap.get("userId")));
			System.out.println(requestMap.get("prod_quantity"));
		CartItem cartItem = new CartItem();
		try {
		cartItem.setProd_id(Integer.parseInt(requestMap.get("prod_id")));
		cartItem.setProd_name(requestMap.get("prod_name"));
		cartItem.setProd_image(requestMap.get("prod_image"));
		cartItem.setProd_price(Integer.parseInt(requestMap.get("prod_price")));
		cartItem.setUserId(Integer.parseInt(requestMap.get("userId")));
		cartItem.setProd_quantity(Integer.parseInt(requestMap.get("prod_quantity")));
		cartItem.setProd_desc(requestMap.get("prod_desc"));
		cartItem.settotalQuantity(Integer.parseInt(requestMap.get("stock")));

		
		cartDao.save(cartItem);
		
		return new ResponseEntity<String>("Item Added Successfully",HttpStatus.OK);
		}

	
	       
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return new ResponseEntity<String>("Item Not Added",HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		else
		
		{
			return new ResponseEntity<String>("Item Already In Cart",HttpStatus.BAD_REQUEST);
		}
		
	}
	@Override
	public ResponseEntity<List<CartItem>> getAll() {
		List<CartItem>cartItems = new ArrayList<>();
		cartItems = cartDao.findAll();
		
		if(!Objects.isNull(cartItems))
		{
			return new ResponseEntity<List<CartItem>>(cartItems,HttpStatus.OK);
		}
		
	  return new ResponseEntity<List<CartItem>>(cartItems,HttpStatus.NO_CONTENT);
	}
	@Override
	public ResponseEntity<List<CartItemWrapper>> getUserCart(Integer userId) {
		List<CartItemWrapper>cartItems = new ArrayList<>();
		cartItems=cartDao.findByUserId(userId);
		
		 return new ResponseEntity<List<CartItemWrapper>>(cartItems,HttpStatus.OK);
	}
	@Override
	public ResponseEntity<Integer> deleteCartItem(Integer id) {
		Optional cartItem = cartDao.findById(id);
		if(!Objects.isNull(cartItem))
		{
			cartDao.deleteById(id);
			return new ResponseEntity<Integer>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	
	
	@Override
	public Integer updateQuantity(List<CartItem> product) {
		
		for(int i =0; i<product.size(); i++) {
	cartDao.updateQuantity(product.get(i).getProd_id(),product.get(i).getProd_quantity());
			
		}
      return 1;		
		
	}
	
	

//	@Override
//	public ResponseEntity<String> deleteAllByUserId(Integer userId) {
//		return cartDao.removeAllByUserId(userId);
//	}

	
//	
//	
//	@Override
//	public ResponseEntity<String> addToCart(Map<String, String> requestMap) {
//
//	    System.out.println(requestMap);
//
//	    int productId = Integer.parseInt(requestMap.get("prod_id"));
//	    int userId = Integer.parseInt(requestMap.get("userId"));
//	    int quantity = Integer.parseInt(requestMap.get("prod_quantity"));
//
//	    // Check if the product is available
//	    if (!isProductAvailable(productId)) {
//	        return new ResponseEntity<>("Product is not available", HttpStatus.BAD_REQUEST);
//	    }
//
//	    // Check if the quantity is available in stock
//	    if (!isQuantityAvailable(productId, quantity)) {
//	        return new ResponseEntity<>("Insufficient quantity in stock", HttpStatus.BAD_REQUEST);
//	    }
//
//	    // Check if the item already exists in the cart
//	    CartItemWrapper cart = cartDao.findInCart(productId, userId);
//	    if (Objects.isNull(cart)) {
//	        CartItem cartItem = new CartItem();
//	        try {
//	            cartItem.setProd_id(productId);
//	            cartItem.setProd_name(requestMap.get("prod_name"));
//	            cartItem.setProd_image(requestMap.get("prod_image"));
//	            cartItem.setProd_price(Integer.parseInt(requestMap.get("prod_price")));
//	            cartItem.setUserId(userId);
//	            cartItem.setProd_quantity(quantity);
//	            cartItem.setProd_desc(requestMap.get("prod_desc"));
//
//	            cartDao.save(cartItem);
//
//	            return new ResponseEntity<>("Item added successfully", HttpStatus.OK);
//	        } catch (Exception ex) {
//	            ex.printStackTrace();
//	        }
//	        return new ResponseEntity<>("Item not added", HttpStatus.INTERNAL_SERVER_ERROR);
//	    } else {
//	        return new ResponseEntity<>("Item already in cart", HttpStatus.BAD_REQUEST);
//	    }
//	}
//	
//	private boolean isProductAvailable(int productId) {
//	    // Check if the product exists in the product repository or inventory service
//	    boolean isAvailable = cartDao.existsById(productId); // Replace 'productRepository' with your actual product repository or inventory service
//
//	    return isAvailable; // Return true if available, false otherwise
//	}
//
//
////	// Helper method to check if the product is available
////	private boolean isProductAvailable(int productId) {
////	    // Add your logic to check if the product is available in the inventory
////	    // Return true if available, false otherwise
////	    // Example: You can query the product repository or inventory service to check availability
////	    return true; // Modify this based on your implementation
////	}
//	
//	private boolean isQuantityAvailable(int productId, int requestedQuantity) {
//	    // Retrieve the available stock quantity for the given productId from the inventory system or database
//	    int availableQuantity = cartItemsService.getStockQuantity(productId); // Replace 'inventoryService' with your actual inventory service or database access
//
//	    // Compare the available stock quantity with the requestedQuantity
//	    if (availableQuantity >= requestedQuantity) {
//	        return true; // Quantity is available in stock
//	    } else {
//	        return false; // Quantity is not available in stock
//	    }
//	}
//
//
////	// Helper method to check if the quantity is available in stock
////	private boolean isQuantityAvailable(int productId, int requestedQuantity) {
////	    // Add your logic to check if the requested quantity is available in stock
////	    // Return true if available, false otherwise
////	    // Example: You can query the inventory service or check against available stock quantity
////	    return true; // Modify this based on your implementation
////	}

	

}