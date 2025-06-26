package com.example.elearning.demo_elearning_api.controller;

import com.example.elearning.demo_elearning_api.dto.CourseDTO;
import com.example.elearning.demo_elearning_api.service.CourseService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<CourseDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/category/{id}")
    public List<CourseDTO> getByCategory(@PathVariable Long id) {
        return service.getByCategory(id);
    }

    @PostMapping
    public CourseDTO create(@RequestBody CourseDTO dto) {
        return service.create(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
