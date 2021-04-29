package com.project.myntra.order.Service;

import com.project.myntra.order.Entity.Cart;
import com.project.myntra.order.Entity.CartItem;
import com.project.myntra.order.Repository.CartItemRepository;
import com.project.myntra.order.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartRepository cartRepository;

    public CartItem addProduct(CartItem cartItem, long cartId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        if(cart.isPresent()) {
            cartItem.setCart(cart.get());
            return cartItemRepository.save(cartItem);
        }
        return null;
    }

    public CartItem updateQuantity(CartItem cartItem, int valToAdd) {
        Optional<CartItem> item = cartItemRepository.findById(cartItem.getId());
        if(item.isPresent()) {
            CartItem itemInDB = item.get();
            int itemOriginalQuantity = itemInDB.getProductQuantity();
            int itemUpdatedQuantity = itemOriginalQuantity + valToAdd;
            if(itemUpdatedQuantity <= 0) {
                deleteItemFromCart(itemInDB);
                return null;
            }
            else {
                itemInDB.setProductQuantity(itemUpdatedQuantity);
                cartItemRepository.save(itemInDB);
                return itemInDB;
            }
        }
        else return null;
    }

    private void deleteItemFromCart(CartItem itemInDB) {
        //Write check if itemInDB don't exist
        //Deleting item from cart if we have the oblject
        //First get Cart
        Optional<Cart> cart = cartRepository.findById(itemInDB.getCart().getCartId());
        if(cart.isPresent()) {
            cart.get().removeItemFromCart(itemInDB);
        }
        cartItemRepository.delete(itemInDB);

    }
    /*
    public void deleteItemFromCart(long cartId, long productId) {

    }

     */
    public void deleteItemFromCart(long itemId) {
        Optional<CartItem> cartItem = cartItemRepository.findById(itemId);
        if(cartItem.isPresent()) {
            deleteItemFromCart(cartItem.get());
        }

    }

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public void deleteAllItemFromCart(Cart cart) {
        List<CartItem> cartItems = cart.getItemsInCart();
        int totItems = cartItems.size();
        for(int i = 0; i < totItems; i++) cartItemRepository.delete(cartItems.get(i));

    }
}
