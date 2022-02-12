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
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
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
    @ResponseBody
    @GetMapping("/success")
    public ResponseEntity login(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        log.info("userData: {}, {}", user.getUsername(), user.getEmail());
        if (userDetails != null) {
            return ResponseEntity.ok().body(null);
        } else {
            return ResponseEntity.badRequest().body(null);
        }

    }


}



