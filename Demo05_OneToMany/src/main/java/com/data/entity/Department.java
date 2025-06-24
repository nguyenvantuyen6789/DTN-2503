package com.data.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE) // khi property k khai báo
// access modifier thì mặc định là private
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "department_name", nullable = false,
            unique = true, length = 100)
    String departmentName;

    // EAGER: tải hăm hở, tải luôn cả dữ liệu của entity liên quan
    // vd entity Employee được tải dữ liệu
//    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    List<Employee> employees;
    // sv config xong MQH 1 N chup lên fb


    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", employees=" + employees +
                '}';
    }
}
