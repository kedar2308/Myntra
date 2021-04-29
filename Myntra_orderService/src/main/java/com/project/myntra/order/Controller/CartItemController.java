package com.project.myntra.order.Controller;

import com.project.myntra.order.Entity.CartItem;
import com.project.myntra.order.Service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/cartItems")
    public List<CartItem> getAllCartItems() { return cartItemService.getAllCartItems(); }



    @PostMapping(value = "/cart/product/{cartId}", consumes = {"application/json"})
    public CartItem addProduct(@RequestBody CartItem cartItem, @PathVariable("cartId") long cartId) {
        return cartItemService.addProduct(cartItem, cartId);
        //If same product is added again.. it find adds the quantity of same product
    }

    @PutMapping("/cart/item/quantity/{val}")
    public CartItem updateQuantity(@RequestBody CartItem cartItem, @PathVariable("val") int valToAdd) {
        return cartItemService.updateQuantity(cartItem, valToAdd);
    }

}
