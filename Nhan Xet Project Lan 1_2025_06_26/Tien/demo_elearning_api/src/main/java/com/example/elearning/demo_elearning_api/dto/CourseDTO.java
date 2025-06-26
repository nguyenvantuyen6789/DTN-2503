package com.example.elearning.demo_elearning_api.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    private Long categoryId;
    private String categoryName;
}

