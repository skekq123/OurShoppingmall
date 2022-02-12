package com.sparta.ourshoppingmall.repository;

import com.sparta.ourshoppingmall.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> getOrdersByUserId(Long userId);
}
