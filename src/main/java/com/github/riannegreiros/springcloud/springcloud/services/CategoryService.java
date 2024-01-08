package com.github.riannegreiros.springcloud.springcloud.services;

import com.github.riannegreiros.springcloud.springcloud.entities.Category;
import com.github.riannegreiros.springcloud.springcloud.entities.Image;
import com.github.riannegreiros.springcloud.springcloud.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Category save(String categoryName, MultipartFile imageFile) throws IOException {
        Category category = new Category();
        category.setName(categoryName);

        Image imageEntity = new Image();
        imageEntity.setImageName(imageFile.getOriginalFilename());
        imageEntity.setContentType(imageFile.getContentType());
        imageEntity.setData(imageFile.getBytes());

        category.setImage(imageEntity);

        return repository.save(category);
    }

    public Category findByName(String name) {
        return repository.findByName(name);
    }

    public Category findById(Long id) {
        Optional<Category> category = repository.findById(id);

        return category.orElseThrow(() -> new EntityNotFoundException("Category not found by id: " + id));
    }
}
