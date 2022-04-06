package com.example.instagramfullrestapi.service;

import com.example.instagramfullrestapi.entity.Attachment;
import com.example.instagramfullrestapi.entity.Posts;
import com.example.instagramfullrestapi.entity.User;
import com.example.instagramfullrestapi.payload.ApiResponse;
import com.example.instagramfullrestapi.payload.UserUpdateDto;
import com.example.instagramfullrestapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public ApiResponse getpost() {
        List<Posts> posts = postRepository.findAll();
        return new ApiResponse("ALl", true, posts);
    }


    public ApiResponse getPostById(UUID id) {
        Optional<Posts> optionalPosts = postRepository.findById(id);
        if (!optionalPosts.isPresent()) {
            return new ApiResponse("post not found", false);
        }
        return new ApiResponse("here", true, optionalPosts.get());
    }

    public ApiResponse deleteById(UUID id) {
        Optional<Posts> optionalPosts = postRepository.findById(id);
        if (!optionalPosts.isPresent()) {
            return new ApiResponse("post not found", false);
        }
        postRepository.deleteById(id);
        return new ApiResponse("deleted", true);
    }
}

