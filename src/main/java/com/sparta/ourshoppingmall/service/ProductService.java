package com.sparta.ourshoppingmall.service;

import com.sparta.ourshoppingmall.domain.Product;
import com.sparta.ourshoppingmall.domain.User;
import com.sparta.ourshoppingmall.repository.ProductRepository;
import com.sparta.ourshoppingmall.requestdto.ProductRequestDto;
import com.sparta.ourshoppingmall.responsedto.ProductLoginResponseDto;
import com.sparta.ourshoppingmall.responsedto.ProductResponseDto;
import com.sparta.ourshoppingmall.validator.ProductValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class ProductService {

    private final ProductValidator productValidator;
    private final ProductRepository productRepository;

    // 상품 등록
    @Transactional
    public Product registerProduct(ProductRequestDto productRequestDto, User user) {
        productValidator.validateProductInput(productRequestDto);
        return productRepository.save(productRequestDto.toEntity(user));
    }

    // 상품 전체 조회
    @Transactional
    public List<ProductLoginResponseDto> viewProducts(Long userId, String username) {
        List<ProductResponseDto> productResponseDtos = productRepository.findAll().stream().map(
                product -> product.toResponseDto()).collect(Collectors.toList());

        List<ProductLoginResponseDto> productLoginResponseDtos = new ArrayList<>();
        ProductLoginResponseDto productLoginResponseDto = new ProductLoginResponseDto(userId, username,productResponseDtos);
        productLoginResponseDtos.add(productLoginResponseDto);

        return productLoginResponseDtos;
    }

    // 상품 수정
    @Transactional
    public  Product updateProduct(Long userId, Long productId, ProductRequestDto productRequestDto) {
        Product product = productRepository.findByIdAndUserId(productId, userId);
        product.updateProduct(productRequestDto);
        productRepository.save(product);
        return product;
    }

    // 상품 삭제
    @Transactional
    public Boolean deleteProduct(Long userId, Long productId) {
        productRepository.findByIdAndUserId(productId, userId);
        productRepository.deleteById(productId);
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            return false;
        }else return true;
    }
}
