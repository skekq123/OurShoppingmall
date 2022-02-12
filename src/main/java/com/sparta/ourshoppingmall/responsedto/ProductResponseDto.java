package com.sparta.ourshoppingmall.responsedto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class ProductResponseDto {
    private Long productId;
    private String title;
    private String img;
    private int price;
    private String category;
    private String address;
    private String desc;
    private Boolean status;
    private LocalDateTime modifiedAt;
    private Long productUserId;
    private String productUsername;
}