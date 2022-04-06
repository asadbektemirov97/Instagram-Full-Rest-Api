package com.example.instagramfullrestapi.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

public class Like {
    @Id
    private UUID id = UUID.randomUUID();

    @ManyToOne
    private Posts posts;

    @ManyToOne
    private User user;
}
