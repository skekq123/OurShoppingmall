package com.sparta.ourshoppingmall.validator;


import com.sparta.ourshoppingmall.domain.User;
import com.sparta.ourshoppingmall.repository.UserRepository;
import com.sparta.ourshoppingmall.requestdto.SignupRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class UserValidator {

    private final UserRepository userRepository;

    public void validateUserInput(SignupRequestDto signupRequestDto){
        String emailValidationPatter = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        String email = signupRequestDto.getEmail();
        if(!(Pattern.matches(emailValidationPatter, email))) {
            throw new IllegalArgumentException("이메일 형식 오류");
        }

        String usernameValidationPatter = "^[a-zA-Z0-9]{2,}$";
        String username = signupRequestDto.getUsername();
        if(!(Pattern.matches(usernameValidationPatter, username))){
            throw new IllegalArgumentException("아이디 형식 오류");
        }
        String passwordValidationPattern= "^[A-Za-z0-9]{6,}$";
        String password = signupRequestDto.getPassword();
        if(!(Pattern.matches(passwordValidationPattern,password))){
            throw new IllegalArgumentException("비밀 번호 형식 오류");
        }
        if(!signupRequestDto.getPasswordChecked().equals(signupRequestDto.getPassword())){
            throw new IllegalArgumentException("비밀번호가 서로 다름");
        }

        Optional<User> user = userRepository.findByEmail(signupRequestDto.getEmail());
        if(user.isPresent()){
            throw new IllegalArgumentException("이메일이 이미 존재함");
        }

        Optional<User> username2 = userRepository.findByUsername(signupRequestDto.getUsername());
        if(username2.isPresent()){
            throw new IllegalArgumentException("닉네임이 이미 존재함");
        }


    }

}
