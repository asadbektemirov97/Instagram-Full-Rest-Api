package com.example.instagramfullrestapi.controller;

import com.example.instagramfullrestapi.payload.ApiResponse;
import com.example.instagramfullrestapi.payload.LoginDto;
import com.example.instagramfullrestapi.payload.RegisterDto;
import com.example.instagramfullrestapi.repository.UserRepository;
import com.example.instagramfullrestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;


    @PostMapping("/register")
    public HttpEntity<?> registerUser(@RequestBody RegisterDto registerDto) {
        ApiResponse apiResponse = userService.registerUser(registerDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
    @PostMapping("/login")
    public HttpEntity<?> loginUser(@RequestBody LoginDto loginDto){
        ApiResponse apiResponse = userService.loginUser(loginDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
}
