package com.sparta.ourshoppingmall.domain;


import com.sparta.ourshoppingmall.requestdto.SignupRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", fetch=FetchType.LAZY)
    private List<Product> products;

    @OneToMany(mappedBy = "user", fetch=FetchType.LAZY)
    private List<Order> orders;

    public User(SignupRequestDto signupRequestDto){
        this.email = signupRequestDto.getEmail();
        this.username = signupRequestDto.getUsername();
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

}