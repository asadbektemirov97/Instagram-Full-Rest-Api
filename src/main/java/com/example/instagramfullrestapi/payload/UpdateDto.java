package com.example.instagramfullrestapi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class UpdateDto {

    @Email
    private String email;

    private String fullName;

    private String username;

    private String password;

    private Integer attachmentId;

    private Date birthday;

}
