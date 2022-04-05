package com.example.instagramfullrestapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
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
@Entity(name = "users")

public class User {

    @Id
    @GeneratedValue
    private UUID id=UUID.randomUUID();

    @Email
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToOne
    private Attachment userImage;

    private Date birthday;


    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;//qachon ro'yhatdan o'tganligi

    @UpdateTimestamp
    private Timestamp updateAt;//oxirgi marta qachon tahrirlanganligi

    public User(String email, String fullName, String username, String password, Attachment userImage, Date birthday) {
        this.email = email;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.userImage = userImage;
        this.birthday = birthday;
    }
}
