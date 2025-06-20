package com.data.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AccountUpdateDTO {

    private int id;

    private String username;

    private String password;

    private String fullName;

    private String address;

    private Date dob;
}
