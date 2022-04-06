package com.example.instagramfullrestapi.controller;

import com.example.instagramfullrestapi.entity.User;
import com.example.instagramfullrestapi.payload.ApiResponse;
import com.example.instagramfullrestapi.payload.UserLoginDto;
import com.example.instagramfullrestapi.payload.UserRegisterDto;
import com.example.instagramfullrestapi.payload.UserUpdateDto;
import com.example.instagramfullrestapi.repository.UserRepository;
import com.example.instagramfullrestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")

public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    private UUID id;


    @PostMapping("/register")
    public HttpEntity<?> registerUser(@RequestBody UserRegisterDto userRegisterDto) {
        ApiResponse apiResponse = userService.registerUser(userRegisterDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
    @PostMapping("/login")
    public HttpEntity<?> loginUser(@RequestBody UserLoginDto userLoginDto){
        ApiResponse apiResponse = userService.loginUser(userLoginDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
    @GetMapping("/users")
    public HttpEntity<?> getUsers(){
        ApiResponse users = userService.getUsers();
        return ResponseEntity.ok().body(users);
    }
    @GetMapping("/user/{id}")
    public HttpEntity<?> getUserById(@PathVariable UUID id){
        ApiResponse user = userService.getUserById(id);
        return ResponseEntity.ok().body(user);
    }
    @DeleteMapping("/user/{id}")
    public HttpEntity<?> deleteById(@PathVariable UUID id){
        ApiResponse apiResponse = userService.deleteById(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200:409).body(apiResponse);
    }

    @PutMapping("/user/{id}")
    public HttpEntity<?> updateById(@RequestParam UUID id, @RequestBody UserUpdateDto userUpdateDto){
        ApiResponse apiResponse = userService.updateUser(id,userUpdateDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200:409).body(apiResponse);

    }

}
