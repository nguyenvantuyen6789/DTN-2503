package com.data.elearning_api.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseDTO {
    int id;
    String name;
    int numberOfSessions;
    int durationHours;
    String description;
    int categoryId;
    String categoryName;
}
