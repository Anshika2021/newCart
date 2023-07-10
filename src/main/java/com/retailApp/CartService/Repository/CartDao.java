package com.retailApp.CartService.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import com.retailApp.CartService.Pojo.CartItem;
import com.retailApp.CartService.Pojo.CartItemWrapper;


public interface CartDao extends JpaRepository<CartItem,Integer> {

//	CartItemWrapper findByProd_id(int id);

	List<CartItemWrapper> findByUserId(Integer userId);

	CartItemWrapper findInCart(Integer prod_id, Integer userId);

	ResponseEntity<String> removeAllByUserId(Integer userId);
	
      @Transactional
	   @Modifying
	   @Query("update CartItem c set c.prod_quantity= :qty where c.prod_id= :prodId")
		Integer updateQuantity (@Param ("prodId") Integer prodId,@Param ("qty") Integer qty);
	


//	int getStockQuantity(int productId);

	//void deleteCartItem(Integer userId, Integer prod_id);

}
