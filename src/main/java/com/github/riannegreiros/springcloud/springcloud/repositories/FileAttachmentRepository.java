package com.github.riannegreiros.springcloud.springcloud.repositories;

import com.github.riannegreiros.springcloud.springcloud.entities.FileAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileAttachmentRepository extends JpaRepository<FileAttachment, Long> {
}