package com.vnaazleen.instrumentDelight.controller;

import com.vnaazleen.instrumentDelight.model.CartModel;
import com.vnaazleen.instrumentDelight.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/home/{id}")
    @CrossOrigin(origins = "http://localhost:4200/")
    public CartModel addToCart(@RequestBody int quantity, @PathVariable Long id) {
        return cartService.addToCart(quantity, id);
    }

    @GetMapping("/cart/{id}")
    @CrossOrigin(origins = "http://localhost:4200/")
    public List<CartModel> showCart(@PathVariable("id") Long id) {
        return cartService.showCart(id);
    }

    @DeleteMapping("/cart/{id}")
    @CrossOrigin(origins = "http://localhost:4200/")
    public String cartItemDelete(@PathVariable("id") Long id) {
        // Todo: change to del specific user's cart item only not all the cart items which have id
        return cartService.deleteCartItem(id);
    
    }
}
