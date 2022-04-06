package com.example.instagramfullrestapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Comments {
    @Id
    private UUID id = UUID.randomUUID();

    @ManyToOne
    @Column(nullable = false)
    private Posts posts;

    @ManyToOne
    @Column(nullable = false)

    private User user;

    private String comment;

}
