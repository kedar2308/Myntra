package com.project.myntra.order.Service;

import com.project.myntra.order.Entity.*;
import com.project.myntra.order.Repository.PurchaseOrderRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderService {
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private CouponService couponService;
    public List<PurchaseOrder> getAllOrders() {
        return purchaseOrderRepository.findAll();
    }


    // Find Cart
    // Create new PO if cart is not empty
    // Fetch all the CartItems
    // Create OrderItems and add them to the new PO
    // Save to repo

    public PurchaseOrder placeOrder(Long cartId) {
        Optional<Cart> cart = cartService.getCart(cartId);
        if(cart.isPresent()) {
            PurchaseOrder purchaseOrder = new PurchaseOrder();
            purchaseOrder.setUserId(cart.get().getUserId());
            purchaseOrder.setDeliveryStatus("Not Delivered");
            purchaseOrderRepository.save(purchaseOrder);
            double totalAmount = 0;
            List<CartItem> itemsInCart = cart.get().getItemsInCart();
            System.out.println("Size = " +itemsInCart.size());
            for(CartItem item : itemsInCart) {
                OrderItem orderItem = orderItemService.addItem(item, purchaseOrder);
                purchaseOrder.addItemInOrder(orderItem);
                purchaseOrderRepository.save(purchaseOrder);
                totalAmount += orderItem.getPrice() * orderItem.getQuantity();
                //cartService.removeItem(item.getId());
            }
            cartService.clearCart(cart.get());
            purchaseOrder.setTotalAmount(totalAmount);
            purchaseOrder.setFinalAmount(totalAmount);
            return purchaseOrderRepository.save(purchaseOrder);
        }
        return null;
        //Include cases when Cart doesn't exist or is empty
        //When this happen few events will be triggered like Choose delivery address , Apply Coupon Code, Payment Method, Assign to DA, finally order is placed
    }

    public PurchaseOrder applyCoupon(Long orderId, String couponCode) {
        Optional<PurchaseOrder> purchaseOrder = purchaseOrderRepository.findById(orderId);
        if(purchaseOrder.isPresent() && purchaseOrder.get().getCoupon() == null) {
            boolean isValidCoupon = couponService.isValid(couponCode);
            if(isValidCoupon) {
                Coupon coupon = couponService.getCoupon(couponCode).get();
                double discountRate = coupon.getDiscount();
                double originalAmount = purchaseOrder.get().getFinalAmount();
                double updatedAmount = (originalAmount * discountRate) / 100;
                purchaseOrder.get().setCoupon(coupon);
                purchaseOrder.get().setFinalAmount(updatedAmount);
                purchaseOrderRepository.save(purchaseOrder.get());
                coupon.addOrder(purchaseOrder.get());

            }
        }
        return purchaseOrder.get();
    }


    public List<OrderItem> getOrderItems(Long orderId) {
        Optional<PurchaseOrder> order = purchaseOrderRepository.findById(orderId);
        List<OrderItem> items = null;
        if(order.isPresent()) {
            items = order.get().getItems();
        }
        return  items;
    }
}
