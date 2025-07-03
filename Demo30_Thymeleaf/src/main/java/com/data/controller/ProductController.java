package com.data.controller;

import com.data.entity.Product;
import com.data.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// @RestController: restful API
//@RestController

// @Controller: Spring MVC
@Controller
@RequestMapping("product")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {

    ProductService productService;

    @GetMapping("list")
    public String getAll() {
        List<Product> products = productService.getAll();

        return "ProductList";
    }

}
