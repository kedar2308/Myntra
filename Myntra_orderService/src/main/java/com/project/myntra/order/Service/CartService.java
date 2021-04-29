package com.project.myntra.order.Service;

import com.project.myntra.order.Entity.Cart;
import com.project.myntra.order.Entity.CartItem;
import com.project.myntra.order.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemService cartItemService;


    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart assignCart(long userId) {
        //if a user already have a cart assigned to Him (Have to do this check)
        Cart cart = new Cart();
        cart.setUserId(userId);
        return cartRepository.save(cart);
    }

    public List<CartItem> getItemsInCart(Long cartId) {
        List<CartItem> items = null;
        Optional<Cart> cart = cartRepository.findById(cartId);
        if(cart.isPresent()) {
            items = cart.get().getItemsInCart();
        }
        return items;
    }

    //We can abstract all such similar function, we shud make an interface for just functionality and implement real service in another class
    public void removeItem(long itemId) { //"Work on this"
        cartItemService.deleteItemFromCart(itemId);

    }

    public Optional<Cart> getCart(Long cartId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        return cart;
    }

    public void clearCart(Cart cart) {
        cartItemService.deleteAllItemFromCart(cart);
        cart.setItemsInCart(new ArrayList<>());
    }
}
