package com.project.myntra.order.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CartItem {
    @Id
    @GeneratedValue
    private long id;
    private long productId;
    private int productQuantity;
    private double price;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "cartId")
    private Cart cart;
}
