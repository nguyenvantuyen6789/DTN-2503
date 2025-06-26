package com.data.elearning_api.controller;

import com.data.elearning_api.dto.CourseDTO;
import com.data.elearning_api.entity.Category;
import com.data.elearning_api.entity.Course;
import com.data.elearning_api.service.CategoryService;
import com.data.elearning_api.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getCoursesByCategory(@PathVariable int id) {
        Category category = categoryService.getById(id);
        if (category == null) {
            return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
        }

        List<Course> courses = courseService.getCoursesByCategoryId(id);

        List<CourseDTO> courseDTOs = new ArrayList<>();

        for (Course course : courses) {
            CourseDTO dto = new CourseDTO();
            dto.setId(course.getId());
            dto.setName(course.getName());
            dto.setNumberOfSessions(course.getNumberOfSessions());
            dto.setDurationHours(course.getDurationHours());
            dto.setDescription(course.getDescription());
            dto.setCategoryId(course.getCategory().getId());
            dto.setCategoryName(course.getCategory().getName());
            courseDTOs.add(dto);
        }

        return new ResponseEntity<>(courseDTOs, HttpStatus.OK);
    }
}
