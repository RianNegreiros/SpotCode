package com.github.riannegreiros.springcloud.springcloud.repositories;

import com.github.riannegreiros.springcloud.springcloud.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}