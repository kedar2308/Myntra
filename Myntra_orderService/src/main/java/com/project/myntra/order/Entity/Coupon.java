package com.project.myntra.order.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Coupon {

    @Id
    @GeneratedValue
    private long id;
    private String couponCode;
    private  double discount;

    @OneToMany(mappedBy = "coupon")
    @JsonManagedReference(value = "coupon-order")
    private List<PurchaseOrder> orders;

    public List<PurchaseOrder> getOrders() {
        return orders;
    }

    public void addOrder(PurchaseOrder order) {
        this.orders.add(order);
    }
    public void removeOrder(PurchaseOrder order) {
        this.orders.remove(order);
    }
}
