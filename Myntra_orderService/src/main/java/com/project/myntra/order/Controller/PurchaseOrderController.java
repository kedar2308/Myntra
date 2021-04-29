package com.project.myntra.order.Controller;

import com.project.myntra.order.Entity.OrderItem;
import com.project.myntra.order.Entity.PurchaseOrder;
import com.project.myntra.order.Service.PurchaseOrderService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @GetMapping("/purchaseOrders")
    public List<PurchaseOrder> getAllPurchaseOrders() { return purchaseOrderService.getAllOrders(); }

    @GetMapping("/purchaseOrder/item/{orderId}")
    public List<OrderItem> getItemsForOrder(@PathVariable("orderId") Long orderId) {
        return purchaseOrderService.getOrderItems(orderId);
    }
    @PostMapping("/cart/order/{cartId}")
    public PurchaseOrder placeOrder(@PathVariable("cartId") Long cartId) {
        return purchaseOrderService.placeOrder(cartId);
    }

    @PutMapping("/order/coupon/{orderId},{couponCode}")
    public PurchaseOrder applyCoupon(@PathVariable("couponCode") String couponCode, @PathVariable("orderId") Long orderId) {
        return purchaseOrderService.applyCoupon(orderId, couponCode);
    }



}
