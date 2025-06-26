package com.example.elearning.demo_elearning_api.service;

import com.example.elearning.demo_elearning_api.dto.CourseDTO;
import com.example.elearning.demo_elearning_api.entity.Category;
import com.example.elearning.demo_elearning_api.entity.Course;
import com.example.elearning.demo_elearning_api.repository.CategoryRepository;
import com.example.elearning.demo_elearning_api.repository.CourseRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepo;
    private final CategoryRepository categoryRepo;

    public CourseService(CourseRepository courseRepo, CategoryRepository categoryRepo) {
        this.courseRepo = courseRepo;
        this.categoryRepo = categoryRepo;
    }

    public List<CourseDTO> getAll() {
        return courseRepo.findAll().stream()
                .map(c -> new CourseDTO(c.getId(), c.getTitle(), c.getDescription(),
                        c.getCategory().getId(), c.getCategory().getName()))
                .collect(Collectors.toList());
    }

    public List<CourseDTO> getByCategory(Long categoryId) {
        return courseRepo.findByCategoryId(categoryId).stream()
                .map(c -> new CourseDTO(c.getId(), c.getTitle(), c.getDescription(),
                        c.getCategory().getId(), c.getCategory().getName()))
                .collect(Collectors.toList());
    }

    public CourseDTO create(CourseDTO dto) {
        Category cat = categoryRepo.findById(dto.getCategoryId()).orElseThrow();
        Course course = new Course(null, dto.getTitle(), dto.getDescription(), cat);
        course = courseRepo.save(course);
        return new CourseDTO(course.getId(), course.getTitle(), course.getDescription(),
                cat.getId(), cat.getName());
    }

    public void delete(Long id) {
        courseRepo.deleteById(id);
    }
}
