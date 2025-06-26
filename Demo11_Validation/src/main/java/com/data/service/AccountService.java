package com.data.service;

import com.data.entity.Account;
import com.data.repository.AccountRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountService {

    AccountRepository accountRepo;

    public boolean create(Account account) {
        accountRepo.save(account);

        return true;
    }

    public Account findByUsername(String username) {
        Account account = accountRepo.findByUsername(username);

        return account;
    }
}
