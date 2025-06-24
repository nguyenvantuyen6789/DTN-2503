package com.data.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter @Setter
@Table(name = "employee")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "username", unique = true, nullable = false,
        columnDefinition = "VARCHAR(50)")
    String username;

    @Column(name = "password", nullable = false,
            columnDefinition = "VARCHAR(50)")
    String password;

    @Column(name = "full_name", nullable = false,
            columnDefinition = "VARCHAR(100)")
    String fullName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    Department department;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", department=" + department +
                '}';
    }
}
