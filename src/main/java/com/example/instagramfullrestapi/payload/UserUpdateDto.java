package com.example.instagramfullrestapi.payload;

import com.example.instagramfullrestapi.entity.Attachment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserUpdateDto {

    @Email
    private String email;

    private String fullName;

    private String username;

    private String password;

    private Integer attachmentId;

    private Date birthday;

}
