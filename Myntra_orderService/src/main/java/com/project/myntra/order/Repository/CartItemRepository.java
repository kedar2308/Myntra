package com.project.myntra.order.Repository;

import com.project.myntra.order.Entity.Cart;
import com.project.myntra.order.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
