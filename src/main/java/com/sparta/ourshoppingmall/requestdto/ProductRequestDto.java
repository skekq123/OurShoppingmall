package com.sparta.ourshoppingmall.requestdto;

import com.sparta.ourshoppingmall.domain.Product;
import com.sparta.ourshoppingmall.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProductRequestDto {
    private String title;
    private int price;
    private String img;
    private String category;
    private String address;
    private String desc;

    public Product toEntity(User user) {
        return Product.builder()
                .title(this.title)
                .price(this.price)
                .img(this.img)
                .category(this.category)
                .address(this.address)
                .desc(this.desc)
                .status(false)
                .user(user)
                .build();
    }
}
