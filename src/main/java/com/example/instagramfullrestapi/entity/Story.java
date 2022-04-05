package com.example.instagramfullrestapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Story {

    @Id
    @GeneratedValue
    private UUID id = UUID.randomUUID();

    @ManyToOne
    private User user;

    @OneToOne
    private Attachment attachment;

    @CreationTimestamp
    private Timestamp createdAt;

    private long second = 86400 * 1000;
}
