package com.sparta.ourshoppingmall.responsedto;

import com.sparta.ourshoppingmall.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {
    private Long userId;
    private String username;
    List<OrderProductResponseDto> products;

    public OrderResponseDto(List<OrderProductResponseDto> products, User user) {
        this.userId = user.getId();
        this.username = user.getUsername();
        this.products = products;
    }
}
