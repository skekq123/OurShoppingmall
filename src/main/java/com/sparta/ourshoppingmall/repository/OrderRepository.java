package com.sparta.ourshoppingmall.repository;

import com.sparta.ourshoppingmall.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
