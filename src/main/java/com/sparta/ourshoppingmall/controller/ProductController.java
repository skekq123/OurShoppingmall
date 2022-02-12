package com.sparta.ourshoppingmall.controller;

import com.sparta.ourshoppingmall.domain.Product;
import com.sparta.ourshoppingmall.domain.User;
import com.sparta.ourshoppingmall.requestdto.ProductRequestDto;
import com.sparta.ourshoppingmall.responsedto.ProductLoginResponseDto;
import com.sparta.ourshoppingmall.security.UserDetailsImpl;
import com.sparta.ourshoppingmall.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    // 상품 등록
    @PostMapping("/product")
    public ResponseEntity registerProduct(
            @RequestBody ProductRequestDto productRequestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ){
        User user = userDetails.getUser();
        Product product = productService.registerProduct(productRequestDto, user);
        if (product != null)
            return ResponseEntity.ok().body(null);
        else return ResponseEntity.badRequest().body(null);
    }

    // 상품 전체 조회
    @GetMapping("/product")
    public List<ProductLoginResponseDto> viewRestaurants(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        Long userId = userDetails.getUser().getId();
        String username = userDetails.getUser().getUsername();
        return productService.viewProducts(userId, username);
    }

    // 상품 수정
    @PutMapping("/product/{productId}")
    public ResponseEntity updateProduct(
            @PathVariable Long productId,
            @RequestBody ProductRequestDto productRequestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        Long userId = userDetails.getUser().getId();
        Product product = productService.updateProduct(userId, productId, productRequestDto);
        if (product != null)
            return ResponseEntity.ok().body(null);
        else return ResponseEntity.badRequest().body(null);
    }

    // 상품 삭제
    @DeleteMapping("/product/{productId}")
    public ResponseEntity deleteProduct(
            @PathVariable Long productId,
            @AuthenticationPrincipal UserDetailsImpl userDetails
        ) {
        Long userId = userDetails.getUser().getId();
        Boolean isDeleted = productService.deleteProduct(userId, productId);
        if (isDeleted == true)
            return ResponseEntity.ok().body(null);
        else return ResponseEntity.badRequest().body(null);
    }
}


