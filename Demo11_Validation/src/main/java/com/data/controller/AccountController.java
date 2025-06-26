package com.data.controller;

import com.data.dto.AccountCreateDTO;
import com.data.entity.Account;
import com.data.service.AccountService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountController {

    AccountService accountService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody AccountCreateDTO accountCreateDTO) {
        Account account = new Account();
        account.setUsername(accountCreateDTO.getUsername());
        account.setEmail(accountCreateDTO.getEmail());
        account.setQuantity(accountCreateDTO.getQuantity());
        account.setBirthday(accountCreateDTO.getBirthday());

        accountService.create(account);

        return new ResponseEntity<>(account, HttpStatus.CREATED); // ma 201
    }
}
