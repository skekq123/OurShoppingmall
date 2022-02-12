package com.sparta.ourshoppingmall.controller;

import com.sparta.ourshoppingmall.domain.User;
import com.sparta.ourshoppingmall.responsedto.ProductResponseDto;
import com.sparta.ourshoppingmall.security.UserDetailsImpl;
import com.sparta.ourshoppingmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{productId}")
    public ProductResponseDto detailProduct(@PathVariable Long productId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        return productService.detailProduct(productId, user);
    }
}
