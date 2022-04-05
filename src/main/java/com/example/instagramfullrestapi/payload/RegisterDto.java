package com.example.instagramfullrestapi.payload;

import com.example.instagramfullrestapi.entity.Attachment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class RegisterDto {

    @Email
    private String email;

    private String fullName;

    private String username;

    private String password;

    private Attachment userImage;

    private Date birthday;


}
