package com.data.elearning_api.service;

import com.data.elearning_api.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getCoursesByCategoryId(int categoryId);
}
