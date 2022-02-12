package com.sparta.ourshoppingmall.service;

import com.sparta.ourshoppingmall.domain.Product;
import com.sparta.ourshoppingmall.domain.User;
import com.sparta.ourshoppingmall.repository.ProductRepository;
import com.sparta.ourshoppingmall.requestdto.ProductRequestDto;
import com.sparta.ourshoppingmall.responsedto.ProductLoginResponseDto;
import com.sparta.ourshoppingmall.responsedto.ProductResponseDto;
import com.sparta.ourshoppingmall.validator.ProductValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class ProductService {

    private final ProductValidator productValidator;
    private final ProductRepository productRepository;

    // 상품 등록
    public Product registerProduct(ProductRequestDto productRequestDto) {
        productValidator.validateProductInput(productRequestDto);
        return productRepository.save(productRequestDto.toEntity());
    }

    // 상품 전체 조회
    public List<ProductLoginResponseDto> viewProducts() {
        List<ProductLoginResponseDto> productLoginResponseDtos = new ArrayList<>();
//        List<Product> products = productRepository.findAll();
        List<ProductResponseDto> productResponseDtos = productRepository.findAll().stream().map(
                Product::toResponseDto).collect(Collectors.toList());



        return productLoginResponseDtos;
    }

    // 상품 수정
    public  Product updateProduct(Long productId, ProductRequestDto productRequestDto) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        product.updateProduct(productRequestDto);
        productRepository.save(product);
        return product;
    }

    // 상품 삭제
    public Product deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        productRepository.delete(product);
        return product;
    }
}
