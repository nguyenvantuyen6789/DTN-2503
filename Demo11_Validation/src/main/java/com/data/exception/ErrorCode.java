package com.data.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
    INVALID_USERNAME_LENGTH(1003, "Username length: 2 - 50", HttpStatus.BAD_REQUEST),
    INVALID_EMAIL(1005, "Email is incorrect format", HttpStatus.BAD_REQUEST),
    INVALID_QUANTITY(1004, "Quantity value: 0 - 2000", HttpStatus.BAD_REQUEST),
    USER_EXIST(1006, "User already exist", HttpStatus.BAD_REQUEST),
    ;

    int code;
    String message;
    HttpStatus status;

    ErrorCode(int code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
