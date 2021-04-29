package com.project.myntra.order.Controller;

import com.project.myntra.order.Entity.OrderItem;
import com.project.myntra.order.Service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/orderItems")
    public List<OrderItem> getAllItems() { return  orderItemService.getAllItems(); }


}
