package com.example.instagramfullrestapi.controller;
import com.example.instagramfullrestapi.payload.ApiResponse;
import com.example.instagramfullrestapi.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/post")
    public HttpEntity<?> getpost(){
        ApiResponse post = postService.getpost();
        return ResponseEntity.ok().body(post);
    }
    @GetMapping("/post/{id}")
    public HttpEntity<?> getUserById(@PathVariable UUID id){
        ApiResponse post = postService.getPostById(id);
        return ResponseEntity.ok().body(post);
    }
    @DeleteMapping("/post/{id}")
    public HttpEntity<?> deleteById(@PathVariable UUID id){
        ApiResponse apiResponse = postService.deleteById(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200:409).body(apiResponse);
    }





}
