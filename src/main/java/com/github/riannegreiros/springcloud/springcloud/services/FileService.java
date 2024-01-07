package com.github.riannegreiros.springcloud.springcloud.services;

import com.github.riannegreiros.springcloud.springcloud.entities.FileAttachment;
import com.github.riannegreiros.springcloud.springcloud.exceptions.FileProcessingException;
import com.github.riannegreiros.springcloud.springcloud.repositories.FileAttachmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    private static final Logger log = LoggerFactory.getLogger(FileService.class);

    @Autowired
    private FileAttachmentRepository repository;

    public void saveFileData(MultipartFile file) {
        try {
            byte[] fileBytes = file.getBytes();

            FileAttachment fileAttachment = new FileAttachment();
            fileAttachment.setData(fileBytes);
            fileAttachment.setFileType(file.getContentType());

            repository.save(fileAttachment);
        } catch (IOException e) {
            log.error("Error occurred while processing file: {}", e.getMessage());
            throw new FileProcessingException("Error occurred while processing file.", e);
        }
    }
}
