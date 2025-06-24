package com.data.controller;

import com.data.dto.DepartmentDTO;
import com.data.entity.Department;
import com.data.entity.Employee;
import com.data.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("department")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Department> departments = departmentService.getAll();

        List<DepartmentDTO> departmentDTOS = new ArrayList<>();

        for (int i = 0; i < departments.size(); i++) {
            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setId(departments.get(i).getId());
            departmentDTO.setDepartmentName(departments.get(i).getDepartmentName());

            if (departments.get(i).getEmployees() != null) {
                List<Employee> employees = departments.get(i).getEmployees();
                System.out.println("Size employees: " + employees.size());
            }

            departmentDTOS.add(departmentDTO);
        }

        return new ResponseEntity<>(departmentDTOS, HttpStatus.OK);
        // sv lam get all employee trong 15p
        // chup len fb
    }

    @GetMapping("search")
    ResponseEntity<?> getByDepartmentName(@RequestParam(required = false) String departmentName) {
        List<Department> departments = departmentService.getByDepartmentName(departmentName);
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();

        departments.forEach(department -> {
            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setId(department.getId());
            departmentDTO.setDepartmentName(department.getDepartmentName());

            departmentDTOS.add(departmentDTO);
        });
        return new ResponseEntity<>(departmentDTOS, HttpStatus.OK);
    }

}
