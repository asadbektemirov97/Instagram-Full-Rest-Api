//package com.example.instagramfullrestapi.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//import java.util.UUID;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Entity
//
//public class PostComments {
//
//    @Id
//    @GeneratedValue
//    private UUID id=UUID.randomUUID();
//
//    @ManyToOne
//    private Posts posts;
//
//    @ManyToOne
//    private User user;
//
//    private String comment;
//
//    @Column(nullable = false, updatable = false)
//    @CreationTimestamp
//    private Timestamp createdAt;//qachon ro'yhatdan o'tganligi
//
//    @UpdateTimestamp
//    private Timestamp updateAt;//oxirgi marta qachon tahrirlanganligi
//}
