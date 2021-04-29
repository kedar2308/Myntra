package com.project.myntra.order.Controller;

import com.project.myntra.order.Entity.Cart;
import com.project.myntra.order.Entity.CartItem;
import com.project.myntra.order.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/carts")
    public List<Cart> getAllCarts() { return cartService.getAllCarts(); }

    @PostMapping("/user/cart/{userId}")
    public Cart assignCartToUser(@PathVariable("userId") long userId) {
        return cartService.assignCart(userId);
    }

    @GetMapping("/cart/items/{cartId}")
    public List<CartItem> getItemsInCart(@PathVariable("cartId") long cartId) {
        return cartService.getItemsInCart(cartId);
    }

    //In this function we are assuming we have cartItem id , we have to create a same function for productId too
    @PutMapping("/cart/item/remove/{cartItemId}")
    public boolean removeItemFromCart(@PathVariable("cartItemId") long itemId) {
           cartService.removeItem(itemId);
           return true;
    }


}
