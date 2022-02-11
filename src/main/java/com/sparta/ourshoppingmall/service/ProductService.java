package com.sparta.ourshoppingmall.service;

import com.sparta.ourshoppingmall.domain.Product;
import com.sparta.ourshoppingmall.domain.User;
import com.sparta.ourshoppingmall.repository.ProductRepository;
import com.sparta.ourshoppingmall.requestdto.ProductRequestDto;
import com.sparta.ourshoppingmall.responsedto.ProductResponseDto;
import com.sparta.ourshoppingmall.validator.ProductValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductValidator productValidator;
    private final ProductRepository productRepository;

    // 상품 등록
    public Product registerProduct(ProductRequestDto productRequestDto) {
        productValidator.validateProductInput(productRequestDto);
        return productRepository.save(productRequestDto.toEntity());
    }

    // 상품 전체 조회
    public List<ProductResponseDto> viewProducts(User user) {
        return productRepository.findAll().stream().map(
                product -> product.toResponseDto(user)).collect(Collectors.toList());
    }

    // 상품 수정
    public ResponseEntity updateProduct(Long productId, ProductRequestDto productRequestDto) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        product.updateProduct(productRequestDto);
        productRepository.save(product);
        return ResponseEntity.ok().body(null);
    }

    // 상품 삭제
    public ResponseEntity deleteProduct(Long productId) {
        productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        productRepository.deleteById(productId);
        return ResponseEntity.ok().body(null);
    }
}
