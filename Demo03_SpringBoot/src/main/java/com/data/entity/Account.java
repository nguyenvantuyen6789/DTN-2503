package com.data.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data // gồm: getter, setter, toString, equal với hash
@Table(name = "tbl_account") // tạo ra bảng tbl_account trong db
public class Account {

//    public static void main(String[] args) {
//        Account account = new Account();
//        // có @Data dùng được getter setter
////        account.setUsername("t1");
//
//        // comment @Data thì k gọi được getter setter
////        account.se
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String password;

    private String fullName;

    private String address;

    private Date dob;
}
