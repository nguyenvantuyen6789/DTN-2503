package com.data.elearning_api.service;

import com.data.elearning_api.entity.Course;
import com.data.elearning_api.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepo;

    @Override
    public List<Course> getCoursesByCategoryId(int categoryId) {
        return courseRepo.findByCategoryId(categoryId);
    }
}
