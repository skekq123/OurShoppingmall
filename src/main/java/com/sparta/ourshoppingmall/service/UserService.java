package com.sparta.ourshoppingmall.service;

import com.sparta.ourshoppingmall.domain.User;
import com.sparta.ourshoppingmall.repository.UserRepository;
import com.sparta.ourshoppingmall.requestdto.SignupRequestDto;
import com.sparta.ourshoppingmall.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final UserValidator userValidator;

    @Transactional
    public User signup(SignupRequestDto signupRequestDto) {
        userValidator.validateUserInput(signupRequestDto);

        log.info("signup Data ={}", signupRequestDto);
        String password = passwordEncoder.encode(signupRequestDto.getPassword());

        User user = new User(signupRequestDto);
        user.setPassword(password);
        return userRepository.save(user);

    }



}
