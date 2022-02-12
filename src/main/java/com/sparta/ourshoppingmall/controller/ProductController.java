package com.sparta.ourshoppingmall.controller;

import com.sparta.ourshoppingmall.responsedto.ProductResponseDto;
import com.sparta.ourshoppingmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ProductResponseDto detailProduct(@PathVariable Long productId) {
        //현재 로그인 정보 sevice parameter에 넘겨주기
        return productService.detailProduct(productId);
    }
}
