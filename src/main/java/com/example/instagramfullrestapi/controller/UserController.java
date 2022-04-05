package com.example.instagramfullrestapi.controller;

import com.example.instagramfullrestapi.payload.ApiResponse;
import com.example.instagramfullrestapi.payload.LoginDto;
import com.example.instagramfullrestapi.payload.RegisterDto;
import com.example.instagramfullrestapi.payload.UpdateDto;
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
    public HttpEntity<?> registerUser(@RequestBody RegisterDto registerDto) {
        ApiResponse apiResponse = userService.registerUser(registerDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
    @PostMapping("/login")
    public HttpEntity<?> loginUser(@RequestBody LoginDto loginDto){
        ApiResponse apiResponse = userService.loginUser(loginDto);
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
    public HttpEntity<?> deleteById(@RequestParam UUID id, @RequestBody UpdateDto updateDto){
        ApiResponse apiResponse = userService.updateUser(id, updateDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200:409).body(apiResponse);

    }

}
