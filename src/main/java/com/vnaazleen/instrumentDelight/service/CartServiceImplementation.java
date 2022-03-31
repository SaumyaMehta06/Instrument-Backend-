package com.vnaazleen.instrumentDelight.service;

import com.vnaazleen.instrumentDelight.model.CartModel;
import com.vnaazleen.instrumentDelight.model.ProductModel;
import com.vnaazleen.instrumentDelight.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartServiceImplementation implements CartService {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public CartModel addToCart(int quantity, Long id) {
        ProductModel product = productService.getProductById(id);
        if(product == null) {
            return null;
        }

        CartModel cartItem = new CartModel();
        cartItem.setProductName(product.getProductName());
        cartItem.setQuantity(quantity);
        cartItem.setPrice(quantity * product.getPrice());
        cartItem.setUserId(2L);

        return cartRepository.save(cartItem);
    }

    @Override
    public List<CartModel> showCart(Long id) {
        return cartRepository.findByUserId(id);
    }

    @Override
    public String deleteCartItem(Long id) {
        cartRepository.deleteById(id);
        return "Item " + id + " deleted successfully";
    }
}



