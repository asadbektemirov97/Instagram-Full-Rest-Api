package com.example.instagramfullrestapi.repository;

import com.example.instagramfullrestapi.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;


public interface PostRepository extends JpaRepository<Posts, UUID> {



}
