package com.sparta.ourshoppingmall.controller;

import com.sparta.ourshoppingmall.domain.User;
import com.sparta.ourshoppingmall.requestdto.SignupRequestDto;
import com.sparta.ourshoppingmall.security.UserDetailsImpl;
import com.sparta.ourshoppingmall.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

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
    public String signup(HttpServletRequest request, HttpServletResponse response){
        return "redirect:http://localhost3000/";
    }


}



