package com.sparta.ourshoppingmall.domain;

import com.sparta.ourshoppingmall.requestdto.ProductRequestDto;
import com.sparta.ourshoppingmall.responsedto.ProductResponseDto;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "product_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String img;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String desc;

    @Column(nullable = false)
    private Boolean status = false;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(mappedBy = "product")
    private Order order;

    public void updateProduct(ProductRequestDto productRequestDto) {
        this.title = productRequestDto.getTitle();
        this.price = productRequestDto.getPrice();
        this.img = productRequestDto.getImg();
        this.category = productRequestDto.getCategory();
        this.address = productRequestDto.getAddress();
        this.desc = productRequestDto.getDesc();
    }

    public ProductResponseDto toResponseDto(User user) {
        return ProductResponseDto.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .productId(this.id)
                .title(this.title)
                .img(this.img)
                .price(this.price)
                .category(this.category)
                .address(this.address)
                .desc(this.desc)
                .status(this.status)
                .modifiedAt(getModifiedAt())
                .build();
    }
}
