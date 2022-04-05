package com.example.instagramfullrestapi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class LoginDto {
    @Email
    private String email;

    private String username;

    private String password;


    public LoginDto(String username, String password) {
        this.username = username;
        this.password = password;

    }
}
