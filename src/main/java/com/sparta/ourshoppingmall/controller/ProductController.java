package com.sparta.ourshoppingmall.controller;

import com.sparta.ourshoppingmall.domain.Product;
import com.sparta.ourshoppingmall.domain.User;
import com.sparta.ourshoppingmall.requestdto.ProductRequestDto;
import com.sparta.ourshoppingmall.responsedto.ProductResponseDto;
import com.sparta.ourshoppingmall.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    // 상품 등록
    @PostMapping("/product")
    public ResponseEntity registerProduct(@RequestBody ProductRequestDto productRequestDto){
        productService.registerProduct(productRequestDto);
        return ResponseEntity.ok().body(null);
    }

    // 상품 전체 조회
    @GetMapping("/product")
    public List<ProductResponseDto> viewRestaurants(User user) {
        return productService.viewProducts(user);
    }

    // 상품 수정
    @PutMapping("/product/{productId}")
    public ResponseEntity updateProduct(@PathVariable Long productId, @RequestBody ProductRequestDto productRequestDto) {
        productService.updateProduct(productId, productRequestDto);
        return ResponseEntity.ok().body(null);
    }

    // 상품 삭제
    @DeleteMapping("/product/{productId}")
    public ResponseEntity deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok().body(null);
    }
}


