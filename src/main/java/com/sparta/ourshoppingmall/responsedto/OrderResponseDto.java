package com.sparta.ourshoppingmall.responsedto;

import com.sparta.ourshoppingmall.domain.Product;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponseDto {
    private Long userId;
    private String username;
    private LocalDateTime createdAt;
    List<Product> products;
}
