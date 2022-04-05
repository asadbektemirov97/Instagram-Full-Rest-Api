package com.example.instagramfullrestapi.service;

import com.example.instagramfullrestapi.entity.Attachment;
import com.example.instagramfullrestapi.entity.User;
import com.example.instagramfullrestapi.payload.ApiResponse;
import com.example.instagramfullrestapi.payload.LoginDto;
import com.example.instagramfullrestapi.payload.RegisterDto;
import com.example.instagramfullrestapi.payload.UpdateDto;
import com.example.instagramfullrestapi.repository.AttachmentRepository;
import com.example.instagramfullrestapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    final UserRepository userRepository;
    final AttachmentRepository attachmentRepository;


    public ApiResponse registerUser(RegisterDto registerDto) {
        boolean existsByUsername = userRepository.existsByUsername(registerDto.getUsername());
        if (existsByUsername) {
            return new ApiResponse("bunday username oldin mavjud", false);
        }

        User user = new User(registerDto.getEmail(), registerDto.getFullName(), registerDto.getUsername(), registerDto.getPassword(), registerDto.getUserImage(), registerDto.getBirthday());
        User save = userRepository.save(user);
        return new ApiResponse("Muvaffaqiyatli ro'yxatdan o'tdingiz", true);
    }

    public ApiResponse loginUser(LoginDto loginDto) {
        Optional<User> byUsernameAndPassword = userRepository.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
        if (!byUsernameAndPassword.isPresent()) {
            return new ApiResponse("usrename yoki parol xato", false);
        }
        return new ApiResponse("hush kelibsiz", true);
    }

    public ApiResponse getUsers() {
        List<User> allUser = userRepository.findAll();
        return new ApiResponse("Hamma foydalanuvchilar", true, allUser);
    }

    public ApiResponse getUserById(UUID id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return new ApiResponse("user not found", false);
        }
        return new ApiResponse("here", true, optionalUser.get());
    }


    public ApiResponse deleteById(UUID id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return new ApiResponse("user not found", false);
        }
        userRepository.deleteById(id);
        return new ApiResponse("deleted", true);
    }

    public ApiResponse updateUser(UUID id, UpdateDto updateDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return new ApiResponse("User not found", false);
        }
        User updateUser = optionalUser.get();
        updateUser.setBirthday(updateDto.getBirthday());
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(updateDto.getAttachmentId());
        if (!optionalAttachment.isPresent()) {
            return new ApiResponse("attachmentId not found", false);
        }
        updateUser.setUserImage(optionalAttachment.get());
        updateUser.setUsername(updateDto.getUsername());
        updateUser.setEmail(updateDto.getEmail());
        updateUser.setFullName(updateDto.getFullName());
        updateUser.setPassword(updateDto.getPassword());
        User savedUser = userRepository.save(updateUser);
        return new ApiResponse("user successfully saved", true, savedUser);
    }


    public ApiResponse searchByUsername(String username) {
        Optional<User> byUsername = userRepository.findByUsername(username);
        if(!byUsername.isPresent()){
            return new ApiResponse("username not found", false);
        }
        userRepository.existsByUsername(username);
        return new ApiResponse("mana senga", true);

    }
}
