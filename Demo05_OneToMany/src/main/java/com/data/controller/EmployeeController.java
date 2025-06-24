package com.data.controller;

import com.data.dto.EmployeeCreateDTO;
import com.data.dto.EmployeeDTO;
import com.data.entity.Department;
import com.data.entity.Employee;
import com.data.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Employee> employees = employeeService.getAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();

        employees.forEach(employee -> {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setUsername(employee.getUsername());
            employeeDTO.setPassword(employee.getPassword());
            employeeDTO.setFullName(employee.getFullName());

            if (employee.getDepartment() != null) {
                employeeDTO.setDepartmentName(employee.getDepartment().getDepartmentName());
            }

            employeeDTOS.add(employeeDTO);
        });

        return new ResponseEntity<>(employeeDTOS, HttpStatus.OK);
        // các bạn giải lao chút nhé
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody EmployeeCreateDTO employeeCreateDTO) {
        Employee employee = new Employee();
        employee.setUsername(employeeCreateDTO.getUsername());
        employee.setPassword(employeeCreateDTO.getPassword());
        employee.setFullName(employeeCreateDTO.getFullName());

        Department department = new Department();
        department.setId(employeeCreateDTO.getDepartmentId());

        employee.setDepartment(department);

        employeeService.create(employee);

        return new ResponseEntity<>("Create Success", HttpStatus.CREATED);
        // sv làm xong chụp lên fb nhé
    }

}
