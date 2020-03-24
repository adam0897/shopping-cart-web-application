package com.example.usermanagementrestapi.service;

import com.example.usermanagementrestapi.entity.CartItem;
import org.springframework.stereotype.Service;

@Service
public interface CartItemService {

    void createCartItem(CartItem cartItem);

    boolean updateCartItem(CartItem cartItem);

    CartItem findOne(int cartItemId);

    boolean deleteCartItem(int cartItemId);

    CartItem findFirstCartItemByShoppingCartIdAndProductId(int shoppingCartId, int productId);
}
