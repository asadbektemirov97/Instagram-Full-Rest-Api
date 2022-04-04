package com.example.instagramfullrestapi.service;

import com.example.instagramfullrestapi.entity.User;
import com.example.instagramfullrestapi.payload.ApiResponse;
import com.example.instagramfullrestapi.payload.LoginDto;
import com.example.instagramfullrestapi.payload.RegisterDto;
import com.example.instagramfullrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public ApiResponse registerUser(RegisterDto registerDto) {
        boolean existsByUsername = userRepository.existsByUsername(registerDto.getUsername());
        if (existsByUsername){
            return new ApiResponse("bunday username oldin mavjud",false);
        }

        User user = new User(registerDto.getEmail(), registerDto.getFullName(),
                registerDto.getUsername(), registerDto.getPassword(),
                registerDto.getUserImage(), registerDto.getBirthday());
        User save = userRepository.save(user);
        return new ApiResponse("Muvaffaqiyatli ro'yxatdan o'tdingiz",true);
    }

    public ApiResponse loginUser(LoginDto loginDto){
        Optional<User> byUsernameAndPassword = userRepository.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
        if (!byUsernameAndPassword.isPresent()){
            return new ApiResponse("usrename yoki parol xato",false);
        }
        return new ApiResponse("hush kelibsiz",true);
    }
}
