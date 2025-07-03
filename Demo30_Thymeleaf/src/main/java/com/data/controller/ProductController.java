package com.data.controller;

import com.data.entity.Product;
import com.data.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    // code leen git
    // sv lam de chay ra giao dien
    // trong 15p
    @GetMapping("list")
    public String getAll(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);

        return "ProductList";
    }

}
