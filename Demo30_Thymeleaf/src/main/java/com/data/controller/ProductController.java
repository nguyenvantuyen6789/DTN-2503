package com.data.controller;

import com.data.entity.Product;
import com.data.repository.ProductRepository;
import com.data.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    ProductRepository productRepo;

    @GetMapping("list")
    public String getAll(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);

        return "ProductList";
    }

    @GetMapping("add")
    public String add() {
        return "ProductAdd";
    }

    @PostMapping("save")
    public String save(@ModelAttribute Product product) {
        productRepo.save(product);

        return "redirect:/product/list";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        productRepo.deleteById(id);

        return "redirect:/product/list";
    }

}
