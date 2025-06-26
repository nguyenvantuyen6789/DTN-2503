package com.data.elearning_api.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Entity
@Table(name = "account")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String username;

    String password;

    @Enumerated(EnumType.STRING)
    ROLE role;

    String email;

    @Temporal(TemporalType.TIMESTAMP)
    Date createAt;

    @Temporal(TemporalType.TIMESTAMP)
    Date updateAt;

    @Temporal(TemporalType.DATE)
    Date dateOfBirth;

    String address;

}
