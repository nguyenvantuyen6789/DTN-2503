package com.data.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Entity
@Table(name = "Account")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "username", nullable = false, unique = true,
    columnDefinition = "VARCHAR(100)")
    String username;

    @Column(name = "email", nullable = false, unique = true,
            columnDefinition = "VARCHAR(100)")
    String email;

    @Column(name = "quantity", nullable = true)
    int quantity;

    @Column(name = "birthday")
    Date birthday;
}
