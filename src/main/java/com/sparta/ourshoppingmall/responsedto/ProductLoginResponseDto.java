package com.sparta.ourshoppingmall.responsedto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class ProductLoginResponseDto {
    private Long userId;
    private String username;
    private List<ProductResponseDto> productResponseDtos;

    public ProductLoginResponseDto (
            Long userId,
            String username,
            List<ProductResponseDto> productResponseDtos) {
        this.userId = userId;
        this.username = username;
        this.productResponseDtos = productResponseDtos;
    }
}
