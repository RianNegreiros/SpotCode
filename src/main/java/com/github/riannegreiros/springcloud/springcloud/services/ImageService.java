package com.github.riannegreiros.springcloud.springcloud.services;

import com.github.riannegreiros.springcloud.springcloud.entities.Image;
import com.github.riannegreiros.springcloud.springcloud.exceptions.ImageNotFoundException;
import com.github.riannegreiros.springcloud.springcloud.exceptions.ImageProcessingException;
import com.github.riannegreiros.springcloud.springcloud.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public String saveImageData(MultipartFile imageFile) {
        try {
            byte[] imageData = imageFile.getBytes();

            Image image = new Image();
            image.setData(imageData);
            image.setContentType(imageFile.getContentType());
            image.setImageName(imageFile.getOriginalFilename());

            Image savedImage = imageRepository.save(image);

            return savedImage.getImageName();
        } catch (IOException e) {
            throw new ImageProcessingException("Error occurred while processing image.", e);
        }
    }

    public byte[] getImageData(String imageName) {
        Image image = imageRepository.findByImageName(imageName);
        if (image != null) {
            return image.getData();
        } else {
            throw new ImageNotFoundException("Image not found: " + imageName);
        }
    }
}
