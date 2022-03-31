package com.vnaazleen.instrumentDelight.service;

import com.vnaazleen.instrumentDelight.model.CartModel;

import java.util.List;

public interface CartService {
    CartModel addToCart(int quantity, Long id);
    
    List<CartModel> showCart(Long id);

	String deleteCartItem(Long id);
}


