package com.sparta.ourshoppingmall.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "order_id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Order(Product product, User user){
        this.product = product;
        this.user = user;
        user.getOrders().add(this);
        product.setOrder(this);
    }



}
