package com.sparta.ourshoppingmall.service;

import com.sparta.ourshoppingmall.domain.Product;
import com.sparta.ourshoppingmall.domain.User;
import com.sparta.ourshoppingmall.repository.ProductRepository;
import com.sparta.ourshoppingmall.responsedto.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDto detailProduct(Long productId, User user) {
        Product product = productRepository.getById(productId);
        ProductResponseDto productResponseDto = new ProductResponseDto(product, user);

        return productResponseDto;
    }
}
