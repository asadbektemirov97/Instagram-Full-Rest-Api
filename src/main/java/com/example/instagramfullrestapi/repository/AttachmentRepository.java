package com.example.instagramfullrestapi.repository;

import com.example.instagramfullrestapi.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
}
