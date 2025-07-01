package com.data.controller;

import com.data.dto.AccountCreateDTO;
import com.data.entity.Account;
import com.data.entity.Product;
import com.data.repository.AccountRepository;
import com.data.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class AccountController {

    AccountRepository accountRepo;

    PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<?> getAll() {
        log.info("Get all account");
        List<Account> accounts = accountRepo.findAll();

        return ResponseEntity.ok(accounts);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody AccountCreateDTO accountCreateDTO) {
        log.info("Create new account");

        Account account = new Account();
        account.setUsername(accountCreateDTO.getUsername());
        account.setPassword(passwordEncoder.encode(accountCreateDTO.getPassword()));
        account.setFullName(accountCreateDTO.getFullName());
        account.setEmail(accountCreateDTO.getEmail());

        accountRepo.save(account);

        return ResponseEntity.ok(account);
    }

}
