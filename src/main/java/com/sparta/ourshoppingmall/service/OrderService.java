package com.sparta.ourshoppingmall.service;

import com.sparta.ourshoppingmall.domain.Order;
import com.sparta.ourshoppingmall.domain.Product;
import com.sparta.ourshoppingmall.repository.OrderRepository;
import com.sparta.ourshoppingmall.repository.ProductRepository;
import com.sparta.ourshoppingmall.responsedto.OrderResponseDto;
import com.sparta.ourshoppingmall.responsedto.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }


    public Product createOrder(Long productId) {
        Product product = productRepository.getById(productId);
        Order order = new Order();
        order.setProduct(product);

        // 현재 로그인 유저 정보 받아서 order에 저장
        // order.setUser

        orderRepository.save(order);

        return product;
    }

    public OrderResponseDto getOrders() {
        //1. userid 가져오기
        //2. userid 로 orderid 가져오기
        //3. orderid로 List<product>, seller_id, name가져오기
        //4. 3에서 가져온 데이터들을 products 리스트에 담기
        //5. userid, name, products를 orderResponseDto에 담아 리턴
        List<ProductResponseDto> products = new ArrayList<>();
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        return orderResponseDto;
    }
}
