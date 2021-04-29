package com.project.myntra.order.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PurchaseOrder {
    @Id
    @GeneratedValue
    private long orderId;
    private long userId;
    private long deliveryAssociateId;
    private String paymentStatus;
    private String deliveryStatus;
    private double totalAmount;
    private double finalAmount;

    @OneToMany(mappedBy = "order")
    @JsonManagedReference(value = "order-item")
    @ToString.Exclude
    private List<OrderItem> items = new ArrayList<>();

    public List<OrderItem> getItems() { return items; }
    public void addItemInOrder(OrderItem item) { this.items.add(item);    }
    public void deleteItemFromOrder(OrderItem item) { this.items.remove(item); }

    @ManyToOne
    @JsonBackReference(value = "coupon-order")
    @JoinColumn(name = "couponId")
    private Coupon coupon;




}