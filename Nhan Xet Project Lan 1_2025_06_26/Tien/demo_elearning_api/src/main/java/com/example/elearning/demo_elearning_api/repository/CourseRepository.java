package com.example.elearning.demo_elearning_api.repository;

import com.example.elearning.demo_elearning_api.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByCategoryId(Long categoryId);
}
