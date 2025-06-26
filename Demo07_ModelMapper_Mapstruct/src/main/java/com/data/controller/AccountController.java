package com.data.controller;

import com.data.dto.res.AccountRes;
import com.data.entity.Account;
import com.data.service.AccountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountController {

    AccountService accountService;

    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Account> accounts = accountService.getAll();
        // bình thường tạo account response rồi set từng thuộc tính
        // c2: dùng model mapper
        List<AccountRes> accountResList = modelMapper
                .map(accounts, new TypeToken<List<AccountRes>>() {}.getType());

        accountResList.forEach(accountRes -> {
            System.out.println(accountRes.getUsername());
        });
        // sv code model mapper rổi chụp ảnh lên fb a xem nha
        // code dua lên git rồi
        // modelmaper chuyển 1 đối tượng sang đối tượng khác
//        Account account = new Account();
//        account.setId("ppp");
//        account.setUsername("t10");
//
//        AccountRes accountRes = modelMapper.map(account, AccountRes.class);
//        System.out.println("Account res id:" + accountRes.getId());
//        System.out.println("Account res username" + accountRes.getUsername());
        // c3: dùng mapstruct

        return ResponseEntity.ok(accountResList);
    }
}
