package com.data.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

// Rest Controller để trả về dữ liệu kiểu json
@RestController
public class ProductController {
    // @GetMapping: lấy dữ liệu
    // @PostMapping: gửi dữ liệu từ client lên để thêm vào db
    // @PutMapping: gửi dữ liệu từ client lên để update vào db
    // @DeleteMapping: gửi dữ liệu từ client lên để xoá trong db

    @GetMapping("product")
    public String getData() {
        return "Money: 5.000.000 USD";
    }

    @GetMapping("product2")
    public int getData2() {
        return 1200;
    }

    @GetMapping("product3")
    public Date getData3() {
        return new Date();
    }

    @GetMapping("product4")
    public boolean getData4() {
        return true;
    }

    // Response Entity: trả về bất kì loại nào
    @GetMapping("product5")
    public ResponseEntity<?> getData5() {
//        return new ResponseEntity<>("Binh nuoc", HttpStatus.OK);
        return new ResponseEntity<>(3500, HttpStatus.OK);
    }
    // sv làm api product5 rồi chụp lên fb


    @PostMapping("product6")
    public ResponseEntity<?> getData6() {
        return new ResponseEntity<>("Created", HttpStatus.OK);
    }


    @PutMapping("product7")
    public ResponseEntity<?> getData7() {
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }
}
