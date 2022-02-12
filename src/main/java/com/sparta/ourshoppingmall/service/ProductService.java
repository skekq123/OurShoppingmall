package com.sparta.ourshoppingmall.service;

import com.sparta.ourshoppingmall.domain.Product;
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

    public ProductResponseDto detailProduct(Long productId) {
        Product product = productRepository.getById(productId);
        //현재 로그인 정보 가져와서, productResponseDto에 useid, username 넣어주기
        ProductResponseDto productResponseDto = new ProductResponseDto(product);

        return productResponseDto;
    }
}
