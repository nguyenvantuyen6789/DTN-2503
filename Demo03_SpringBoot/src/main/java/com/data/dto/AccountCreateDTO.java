package com.data.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AccountCreateDTO {

    private String username;

    private String password;

    private String fullName;

    private String address;

    private Date dob;
}
