package com.data.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Table(name = "product")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(name = "product_name", unique = true, nullable = false,
    columnDefinition = "VARCHAR(100)")
    String productName;

    @Column(name = "price", nullable = true,
            columnDefinition = "INT UNSIGNED")
    int price;
}
