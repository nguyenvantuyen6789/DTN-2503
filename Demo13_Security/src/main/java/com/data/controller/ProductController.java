package com.data.controller;

import com.data.entity.Product;
import com.data.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ProductController {

    ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        log.info("Get all products");
//        log.warn("Get all products");
//        log.error("Get all products");
        List<Product> products = productService.getAll();

        return ResponseEntity.ok(products);
    }

}
