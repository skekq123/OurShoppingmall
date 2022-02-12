package com.sparta.ourshoppingmall.validator;

import com.sparta.ourshoppingmall.requestdto.ProductRequestDto;
import org.springframework.stereotype.Component;

@Component
public class ProductValidator {
    public void validateProductInput(ProductRequestDto productRequestDto) {
        // 가격이 음수 일 때 예외 발생
        if (productRequestDto.getPrice() < 0) {
            throw new IllegalArgumentException("가격은 0원 이상으로 등록 바랍니다.");
        }

        if (productRequestDto.getDesc().length() < 255) {
            throw new IllegalArgumentException("상품 설명은 255자 이내로 작성 바랍니다.");
        }
    }
}
