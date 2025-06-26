package com.example.elearning.demo_elearning_api.repository;

import com.example.elearning.demo_elearning_api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
