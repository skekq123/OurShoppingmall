package com.sparta.ourshoppingmall.validator;

import com.sparta.ourshoppingmall.domain.Product;
import com.sparta.ourshoppingmall.domain.User;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator {
    public void IsProductSold(Product product) {
        if(product.getStatus()) throw new IllegalArgumentException("이미 거래된 상품입니다.");
    }
    public void validateOrder(Product product, User user) {
        if(product.getUser().getId() == user.getId()) throw new IllegalArgumentException("본인의 상품은 거래할 수 없습니다.");
    }
}
