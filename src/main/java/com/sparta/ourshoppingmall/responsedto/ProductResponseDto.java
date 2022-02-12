package com.sparta.ourshoppingmall.responsedto;

import com.sparta.ourshoppingmall.domain.Product;
import com.sparta.ourshoppingmall.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    public ProductResponseDto(Product product, Long userId, String username) {
        this.productId = product.getId();
        this.status = product.getStatus();
        this.title = product.getTitle();
        this.img = product.getImg();
        this.price = product.getPrice();
        this.category = product.getCategory();
        this.address = product.getAddress();
        this.desc = product.getDesc();
        this.modifiedAt = product.getModifiedAt();
        this.productUserId = userId;
        this.productUsername = username;
    }
}
