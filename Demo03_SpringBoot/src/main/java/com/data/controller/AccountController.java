package com.data.controller;

import com.data.entity.Account;
import com.data.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AccountController {

    @Autowired
    private AccountRepository accountRepo;

    @GetMapping("account")
    public ResponseEntity<?> getAll() {
        List<Account> accounts = accountRepo.findAll();

        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    // lấy dữ liệu theo đường dẫn
    @GetMapping("search/{name}/{email}")
    public ResponseEntity<?> search(@PathVariable String name,
                                    @PathVariable String email) {
        return new ResponseEntity<>("Name: " + name + ". Email: " + email, HttpStatus.OK);
    }
}
