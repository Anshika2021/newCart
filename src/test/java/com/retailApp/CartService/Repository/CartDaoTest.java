package com.retailApp.CartService.Repository;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.retailApp.CartService.Pojo.CartItem;
import com.retailApp.CartService.Pojo.CartItemWrapper;
import com.retailApp.CartService.Repository.CartDao;

public class CartDaoTest {
	


    
    @Mock
    private CartDao cartDao;
    
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    @DisplayName("Test findById Success")
    public void testFindByIdSuccess() {
        CartItem cartItem = new CartItem();
        cartItem.setProd_id(1);
        cartItem.setProd_name("Test Product");
        cartItem.setProd_image("test_image.jpg");
        cartItem.setProd_price(10);
        cartItem.setUserId(1);
        cartItem.setProd_quantity(1);
//        cartItem.setProd_desc("Test Description");
        
        when(cartDao.findById(1)).thenReturn(Optional.of(cartItem));
        
        Optional<CartItem> result = cartDao.findById(1);
        
        assertThat(result).isNotEmpty();
        assertThat(result.get().getProd_name()).isEqualTo(cartItem.getProd_name());
    }
    
    @Test
    @DisplayName("Test findByUserId Success")
    public void testFindByUserIdSuccess() {
        CartItemWrapper cartItemWrapper = new CartItemWrapper();
        cartItemWrapper.setProd_id(1);
        cartItemWrapper.setProd_name("Test Product");
        cartItemWrapper.setProd_image("test_image.jpg");
        cartItemWrapper.setProd_price(10);
        cartItemWrapper.setUserId(1);
        cartItemWrapper.setProd_quantity(1);
//        cartItemWrapper.setProd_desc("Test Description");
        
        List<CartItemWrapper> cartItemList = new ArrayList<>();
        cartItemList.add(cartItemWrapper);
        
        when(cartDao.findByUserId(1)).thenReturn(cartItemList);
        
        List<CartItemWrapper> result = cartDao.findByUserId(1);
        
        assertThat(result).isNotEmpty();
        assertThat(result.get(0).getProd_name()).isEqualTo(cartItemWrapper.getProd_name());
    }
    
    @Test
    @DisplayName("Test findInCart Success")
    public void testFindInCartSuccess() {
        CartItemWrapper cartItemWrapper = new CartItemWrapper();
        cartItemWrapper.setProd_id(1);
        cartItemWrapper.setProd_name("Test Product");
        cartItemWrapper.setProd_image("test_image.jpg");
        cartItemWrapper.setProd_price(10);
        cartItemWrapper.setUserId(1);
        cartItemWrapper.setProd_quantity(1);
        
        when(cartDao.findInCart(1, 1)).thenReturn(cartItemWrapper);
        
        CartItemWrapper result = cartDao.findInCart(1, 1);
        
        assertThat(result).isNotNull();
        assertThat(result.getProd_name()).isEqualTo(cartItemWrapper.getProd_name());
    }
    
   
//    @Test
//    public void testRemoveAllByUserId() {
//        Integer userId = 1;
//
//        ResponseEntity<Integer> cartItemWrapper1 = new CartItemWrapper();
//        cartItemWrapper1.setUserId(userId);
//        
//      when(cartDao.removeAllByUserId(1)).thenReturn(cartItemWrapper1);
//        
//        CartItemWrapper result = cartDao.removeAllByUserId(1);
//
////        cartDao.add(cartItemWrapper1);
////
////        CartItemWrapper cartItemWrapper2 = new CartItemWrapper();
////        cartItemWrapper2.setUserId(userId);
////        List<CartItemWrapper> cartItemList = new ArrayList<>();
////
////        cartDao.save(cartItemWrapper2);
//
//        ResponseEntity<Integer> response = cartDao.removeAllByUserId(userId);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//
//        List<CartItemWrapper> cartItems = cartDao.findByUserId(userId);
//        assertEquals(0, cartItems.size());
//    }

}
 

