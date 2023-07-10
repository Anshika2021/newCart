////package com.retailApp.CartService.CartServices;
//////
//////public class CartItemsServiceImplTest {
//////
//////}
////
////
////import static org.junit.jupiter.api.Assertions.assertEquals;
////import static org.mockito.Mockito.mock;
////import static org.mockito.Mockito.when;
////
////import java.util.HashMap;
////import java.util.Map;
////
////import org.aspectj.lang.annotation.Before;
////import org.junit.jupiter.api.BeforeAll;
////import org.junit.jupiter.api.Test;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////
////import com.retailApp.CartService.Pojo.CartItemWrapper;
////import com.retailApp.CartService.Repository.CartDao;
////
////public class CartItemsServiceImplTest {
////
////    private CartItemsServiceImpl cartItemsService;
////    private CartDao cartDaoMock;
////
////    @Before
////    public void setUp() {
////        cartDaoMock = mock(CartDao.class);
////        cartItemsService = new CartItemsServiceImpl();
////        cartItemsService.cartDao = cartDaoMock;
////    }
////
////    @Test
////    public void testAddToCart() {
////        Map<String, String> requestMap = new HashMap<>();
////        requestMap.put("prod_id", "1");
////        requestMap.put("prod_name", "Product 1");
////        requestMap.put("prod_image", "image1.jpg");
////        requestMap.put("prod_price", "10");
////        requestMap.put("userId", "100");
////        requestMap.put("prod_quantity", "2");
////        requestMap.put("prod_desc", "Product 1 description");
////
////        CartItemWrapper cartItemWrapper = null; // no item in cart yet
////        when(cartDaoMock.findInCart(1, 100)).thenReturn(cartItemWrapper);
////
////        ResponseEntity<String> response = cartItemsService.addToCart(requestMap);
////
////        assertEquals(HttpStatus.OK, response.getStatusCode());
////        assertEquals("Item Added Successfully", response.getBody());
////    }
////
////    @Test
////    public void testAddToCartItemAlreadyInCart() {
////        Map<String, String> requestMap = new HashMap<>();
////        requestMap.put("prod_id", "1");
////        requestMap.put("prod_name", "Product 1");
////        requestMap.put("prod_image", "image1.jpg");
////        requestMap.put("prod_price", "10");
////        requestMap.put("userId", "100");
////        requestMap.put("prod_quantity", "2");
////        requestMap.put("prod_desc", "Product 1 description");
////
////        CartItemWrapper cartItemWrapper = new CartItemWrapper(); // item already in cart
////        when(cartDaoMock.findInCart(1, 100)).thenReturn(cartItemWrapper);
////
////        ResponseEntity<String> response = cartItemsService.addToCart(requestMap);
////
////        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
////        assertEquals("Item Already In Cart", response.getBody());
////    }
////
////    @Test
////    public void testAddToCartInvalidInput() {
////        Map<String, String> requestMap = new HashMap<>();
////        requestMap.put("prod_id", "1");
////        requestMap.put("prod_name", "Product 1");
////        requestMap.put("prod_image", "image1.jpg");
////        requestMap.put("prod_price", "10");
////        requestMap.put("userId", "100");
////        requestMap.put("prod_quantity", "invalid_quantity");
////        requestMap.put("prod_desc", "Product 1 description");
////
////        ResponseEntity<String> response = cartItemsService.addToCart(requestMap);
////
////        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
////        assertEquals("Item Not Added", response.getBody());
////    }
////}
////
////
////
////
//
//
//package com.retailApp.CartService.CartServices;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import com.retailApp.CartService.Pojo.CartItem;
//import com.retailApp.CartService.Pojo.CartItemWrapper;
//import com.retailApp.CartService.Repository.CartDao;
//
//public class CartItemsServiceImplTest {
//
//    private CartDao cartDaoMock;
//    private CartItemsService cartItemsService;
//
//    @Before
//    public void setUp() {
//        cartDaoMock = mock(CartDao.class);
//        cartItemsService = new CartItemsServiceImpl();
////        cartItemsService.cartItem= cartDaoMock;
//    }
//
//    @Test
//    public void testAddToCart() {
//        // Arrange
//        Map<String, String> requestMap = new HashMap<>();
//        requestMap.put("prod_id", "1");
//        requestMap.put("prod_name", "testProduct");
////        requestMap.put("prod_image", "testImage");
//        requestMap.put("prod_price", "10");
////        requestMap.put("userId", "1");
//        requestMap.put("prod_quantity", "2");
//        requestMap.put("prod_desc", "testDescription");
//        when(cartDaoMock.findInCart(anyInt(), anyInt())).thenReturn(null);
//
//        // Act
//        ResponseEntity<String> response = cartItemsService.addToCart(requestMap);
//
//        // Assert
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("Item Added Successfully", response.getBody());
//    }
//
//    @Test
//    public void testGetAll() {
//        // Arrange
//        List<CartItem> cartItems = List.of(new CartItem(), new CartItem());
//        when(cartDaoMock.findAll()).thenReturn(cartItems);
//
//        // Act
//        ResponseEntity<List<CartItem>> response = cartItemsService.getAll();
//
//        // Assert
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(cartItems, response.getBody());
//    }
//
//    @Test
//    public void testGetUserCart() {
//        // Arrange
//        List<CartItemWrapper> cartItems = List.of(new CartItemWrapper(), new CartItemWrapper());
//        when(cartDaoMock.findByUserId(anyInt())).thenReturn(cartItems);
//
//        // Act
//        ResponseEntity<List<CartItemWrapper>> response = cartItemsService.getUserCart(1);
//
//        // Assert
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(cartItems, response.getBody());
//    }
////
////    @Test
////    public void testDeleteCartItem() {
////        // Arrange
////        int itemId = 1;
////        when(cartDaoMock.findById(itemId)).thenReturn(java.util.Optional.of(new CartItem()));
////
////        // Act
////        ResponseEntity<String> response = cartItemsService.deleteCartItem(itemId);
////
////        // Assert
////        assertEquals(HttpStatus.OK, response.getStatusCode());
////        assertEquals("item Deleted Sucessfully", response.getBody());
////    }
////
////    @Test
////    public void testDeleteCartItemNotFound() {
////        // Arrange
////        int itemId = 1;
////        when(cartDaoMock.findById(itemId)).thenReturn(java.util.Optional.empty());
////
////        // Act
////        ResponseEntity<String> response = cartItemsService.deleteCartItem(itemId);
////
////        // Assert
////        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
////        assertEquals("item Not Present", response.getBody());
////    }
//
//}
