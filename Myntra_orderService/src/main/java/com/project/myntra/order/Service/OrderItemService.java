package com.project.myntra.order.Service;

import com.project.myntra.order.Entity.CartItem;
import com.project.myntra.order.Entity.OrderItem;
import com.project.myntra.order.Entity.PurchaseOrder;
import com.project.myntra.order.Repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public OrderItem addItem(CartItem item, PurchaseOrder purchaseOrder) {
        OrderItem orderItem = new OrderItem();
        //Map cartItem into Order Item

        orderItem.setProductId(item.getProductId());
        orderItem.setPrice(item.getPrice());
        orderItem.setQuantity(item.getProductQuantity());
        orderItem.setOrder(purchaseOrder);

        return orderItemRepository.save(orderItem);

    }

    public List<OrderItem> getAllItems() {
        return orderItemRepository.findAll();
    }
}
