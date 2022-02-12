package com.sparta.ourshoppingmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class OurshoppingmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(OurshoppingmallApplication.class, args);
    }

}