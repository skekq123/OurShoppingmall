package com.sparta.ourshoppingmall.requestdto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class SignupRequestDto {
    private String email;
    private String username;
    private String password;
    private String passwordChecked;
}
