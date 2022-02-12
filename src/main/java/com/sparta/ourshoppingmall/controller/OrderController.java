package com.sparta.ourshoppingmall.controller;

import com.sparta.ourshoppingmall.domain.Product;
import com.sparta.ourshoppingmall.domain.User;
import com.sparta.ourshoppingmall.responsedto.OrderResponseDto;
import com.sparta.ourshoppingmall.security.UserDetailsImpl;
import com.sparta.ourshoppingmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order/{productId}")
    public ResponseEntity createOrder(@PathVariable Long productId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        Product product = orderService.createOrder(productId, user);

        if(product != null) return ResponseEntity.ok().body(null);
        else return ResponseEntity.badRequest().body(null);
    }
    @GetMapping("/orders")
    public OrderResponseDto getOrders(@AuthenticationPrincipal UserDetailsImpl userDetails){
        User user = userDetails.getUser();
        return orderService.getOrders(user);
    }
}
