package com.example.instagramfullrestapi.service;

import com.example.instagramfullrestapi.entity.Attachment;
import com.example.instagramfullrestapi.entity.User;
import com.example.instagramfullrestapi.payload.ApiResponse;
import com.example.instagramfullrestapi.payload.UserLoginDto;
import com.example.instagramfullrestapi.payload.UserRegisterDto;
import com.example.instagramfullrestapi.payload.UserUpdateDto;
import com.example.instagramfullrestapi.repository.AttachmentRepository;
import com.example.instagramfullrestapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    final UserRepository userRepository;
    final AttachmentRepository attachmentRepository;


    public ApiResponse registerUser(UserRegisterDto userRegisterDto) {
        boolean existsByUsername = userRepository.existsByUsername(userRegisterDto.getUsername());
        if (existsByUsername) {
            return new ApiResponse("bunday username oldin mavjud", false);
        }

        User user = new User(userRegisterDto.getEmail(), userRegisterDto.getFullName(), userRegisterDto.getUsername(), userRegisterDto.getPassword(), userRegisterDto.getUserImage(), userRegisterDto.getBirthday());
        User save = userRepository.save(user);
        return new ApiResponse("Muvaffaqiyatli ro'yxatdan o'tdingiz", true);
    }

    public ApiResponse loginUser(UserLoginDto userLoginDto) {
        Optional<User> byUsernameAndPassword = userRepository.findByUsernameAndPassword(userLoginDto.getUsername(), userLoginDto.getPassword());
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

    public ApiResponse updateUser(UUID id, UserUpdateDto userUpdateDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return new ApiResponse("User not found", false);
        }
        User updateUser = optionalUser.get();
        updateUser.setBirthday(userUpdateDto.getBirthday());
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(userUpdateDto.getAttachmentId());
        if (!optionalAttachment.isPresent()) {
            return new ApiResponse("attachmentId not found", false);
        }
        updateUser.setUserImage(optionalAttachment.get());
        updateUser.setUsername(userUpdateDto.getUsername());
        updateUser.setEmail(userUpdateDto.getEmail());
        updateUser.setFullName(userUpdateDto.getFullName());
        updateUser.setPassword(userUpdateDto.getPassword());
        User savedUser = userRepository.save(updateUser);
        return new ApiResponse("user successfully saved", true, savedUser);
    }

}
