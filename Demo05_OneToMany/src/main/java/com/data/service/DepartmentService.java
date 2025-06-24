package com.data.service;

import com.data.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAll();

    List<Department> getByDepartmentName(String departmentName);
}
