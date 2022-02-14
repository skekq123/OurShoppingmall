package com.sparta.ourshoppingmall.controller;

import com.sparta.ourshoppingmall.domain.User;
import com.sparta.ourshoppingmall.requestdto.SignupRequestDto;
import com.sparta.ourshoppingmall.security.UserDetailsImpl;
import com.sparta.ourshoppingmall.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@Controller
@Slf4j
public class UserController {

    private final UserService userService;

    @ResponseBody
    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody SignupRequestDto signupRequestDto) {
        User signupUser = userService.signup(signupRequestDto);
        if (signupUser != null) {
            return ResponseEntity.ok().body(null);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/success")
    public String login() {
        return "redirect:http://localhost:3000/";
    }


}



