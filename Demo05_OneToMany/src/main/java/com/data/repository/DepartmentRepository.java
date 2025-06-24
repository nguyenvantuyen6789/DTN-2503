package com.data.repository;

import com.data.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    // named query: tạo ra câu truy vấn theo tên method
    // cấu trúc: findBy + property (param)
    // vd: lấy list phòng ban theo departmentName
    //      =>findByDepartmentName(String departmentName)

    // => sql: SELECT * FROM department WHERE departmentName = ?
    List<Department> findByDepartmentName(String departmentName);

    // dùng "And", "Or"
}
