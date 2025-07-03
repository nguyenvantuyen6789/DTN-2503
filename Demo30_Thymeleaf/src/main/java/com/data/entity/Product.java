package com.data.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name = "product")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "productName", unique = true, nullable = true,
    columnDefinition = "VARCHAR(100)")
    String productName;

    @Column(name = "price", unique = false, nullable = true)
    long price;

    @Column(name = "description", unique = false, nullable = false,
            columnDefinition = "TEXT")
    String description;
}
