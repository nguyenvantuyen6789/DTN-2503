package com.data.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "account")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(name = "username", nullable = false, unique = true,
    columnDefinition = "VARCHAR(100)")
    String username;

    @Column(name = "password", nullable = false, unique = false,
            columnDefinition = "VARCHAR(100)")
    String password;

    @Column(name = "full_name", nullable = false, unique = false,
            columnDefinition = "VARCHAR(100)")
    String fullName;

    @Column(name = "email", nullable = true, unique = true,
            columnDefinition = "VARCHAR(100)")
    String email;

    String role;

}
