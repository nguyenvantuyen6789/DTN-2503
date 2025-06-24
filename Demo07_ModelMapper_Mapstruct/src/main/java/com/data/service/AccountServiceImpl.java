package com.data.service;

import com.data.entity.Account;
import com.data.repository.AccountRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // tạo constructor cho các thuộc tính final
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountServiceImpl implements AccountService {

    // c1: @RequiredArgsConstructor + final
//    final AccountRepository accountRepo;
    // c2: @RequiredArgsConstructor + makeFinal=true
    AccountRepository accountRepo;

    @Override
    public List<Account> getAll() {
        return accountRepo.findAll();
    }
}
