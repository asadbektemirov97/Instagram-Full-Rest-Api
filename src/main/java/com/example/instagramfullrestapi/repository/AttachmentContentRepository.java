package com.example.instagramfullrestapi.repository;

import com.example.instagramfullrestapi.entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Integer> {

    Optional<AttachmentContent> findByAttachmentId(Integer attachment_id);
}
