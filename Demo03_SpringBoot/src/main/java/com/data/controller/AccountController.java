package com.data.controller;

import com.data.dto.AccountCreateDTO;
import com.data.dto.AccountUpdateDTO;
import com.data.entity.Account;
import com.data.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepo;

    @GetMapping
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

    @GetMapping("search2")
    public ResponseEntity<?> search2(@RequestParam(required = false) String learn,
                                     @RequestParam(required = false) String name) {
        return new ResponseEntity<>("Learn: " + learn + ". Name: " + name, HttpStatus.OK);

    }
    // dto: data transfer object: đối tượng để truyền dữ liệu
    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody AccountCreateDTO accountCreateDTO) {
        System.out.println(accountCreateDTO);
        // đưa dữ liệu DTO sang entity
        Account account = new Account();
        account.setUsername(accountCreateDTO.getUsername());
        account.setPassword(accountCreateDTO.getPassword());
        account.setFullName(accountCreateDTO.getFullName());
        account.setAddress(accountCreateDTO.getAddress());
        account.setDob(accountCreateDTO.getDob());

        accountRepo.save(account);

        return new ResponseEntity<>("Create success", HttpStatus.OK);
        // sv xong gui ảnh lên fb
    }
    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody AccountUpdateDTO accountUpdateDTO) {
        // đưa dữ liệu DTO sang entity
        Account account = new Account();
        account.setId(accountUpdateDTO.getId());
        account.setUsername(accountUpdateDTO.getUsername());
        account.setPassword(accountUpdateDTO.getPassword());
        account.setFullName(accountUpdateDTO.getFullName());
        account.setAddress(accountUpdateDTO.getAddress());
        account.setDob(accountUpdateDTO.getDob());

        accountRepo.save(account);

        return new ResponseEntity<>("Update success", HttpStatus.OK);
        // sv xong gui ảnh lên fb
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Account account = accountRepo.findById(id).orElse(null);
        if (account == null) {
            return new ResponseEntity<>("Id không tồn tại: " + id, HttpStatus.BAD_REQUEST);
        }

        accountRepo.delete(account);
        return new ResponseEntity<>("Xoá thành công id: " + id, HttpStatus.OK);
        // sv xong gui ảnh lên fb
    }
}
