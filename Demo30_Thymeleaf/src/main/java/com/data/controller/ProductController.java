package com.data.controller;

import com.data.entity.Product;
import com.data.repository.ProductRepository;
import com.data.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

    // send email
    JavaMailSender javaMailSender;

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

    // sv thuc hanh gui email: 10p
    @GetMapping("send-email")
    public String sendEmail() {
        try {
            SimpleMailMessage mail = new SimpleMailMessage();

            mail.setFrom("nguyenvantuyen6789@gmail.com");
            mail.setTo("nguyenvantuyen6789@gmail.com");
            mail.setSubject("Thu moi phong van");
            mail.setText("Chung toi han hanh moi ban tham gia");

            javaMailSender.send(mail);
            System.out.println("Send email success!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "ProductList";
    }

}
