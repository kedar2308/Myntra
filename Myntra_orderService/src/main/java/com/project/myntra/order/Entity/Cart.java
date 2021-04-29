package com.project.myntra.order.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cart {

    @Id
    @GeneratedValue
    private long cartId;
    private long userId;

    @OneToMany(mappedBy = "cart")
    @JsonManagedReference
    @ToString.Exclude
    private List<CartItem> itemsInCart = new ArrayList<>();


    public List<CartItem> getItemsInCart() {
        return itemsInCart;
    }
    public void addItemInCart(CartItem item) {
        this.itemsInCart.add(item);
    }
    public void removeItemFromCart(CartItem item) {
        this.itemsInCart.remove(item);
    }
}
