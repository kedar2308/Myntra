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
public class OrderItem {

    @Id
    @GeneratedValue
    private long id;
    private long productId;
    private int quantity;
    private double price;

    @ManyToOne
    @JsonBackReference(value = "order-item")
    @JoinColumn(name = "orderId")
    private PurchaseOrder order;
}
