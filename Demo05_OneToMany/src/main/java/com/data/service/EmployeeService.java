package com.data.service;

import com.data.entity.Employee;

import java.util.List;

public interface EmployeeService {
    boolean create(Employee employee);

    List<Employee> getAll();
}
