package com.example.instagramfullrestapi.repository;

import com.example.instagramfullrestapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.Email;
import java.util.Optional;
import java.util.UUID;


public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByUsername(String username);


    Optional<User> findByEmailAndPassword(@Email String email, String password);

    Optional<User> findByUsernameAndPassword(String username, String password);


}
