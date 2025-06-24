package com.data.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name = "account")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {

    @Id
    // chuỗi UUID tự sinh ngẫu nhiên
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 40)
    String id;

    @Column(name = "username", unique = true, nullable = false,
    columnDefinition = "VARCHAR(50)")
    String username;

    @Column(name = "password", unique = false, nullable = false,
    columnDefinition = "VARCHAR(50)")
    String password;

    @Column(name = "email", unique = true, nullable = false,
    columnDefinition = "VARCHAR(100)")
    String email;
}
