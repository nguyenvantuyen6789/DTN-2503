package com.data.service;

import com.data.dto.EmployeeCreateDTO;
import com.data.entity.Employee;
import com.data.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepo;

    public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public boolean create(Employee employee) {
        employeeRepo.save(employee);
        return false;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = employeeRepo.findAll();
        return employees;
    }
}
