package com.data.exception;

import com.data.dto.ApiResponseDTO;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Hidden
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity argException(MethodArgumentNotValidException exception) {
        List<ApiResponseDTO> result = new ArrayList<>();

        for (Object object : exception.getBindingResult().getAllErrors()) {
            FieldError err = (FieldError) object;
            String key = err.getDefaultMessage();

            ErrorCode errorCode = ErrorCode.valueOf(key);
            // từ errorCode lấy ra bộ gồm code, message, status
            ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
            apiResponseDTO.setCode(errorCode.getCode());
            apiResponseDTO.setMessage(errorCode.getMessage());
            apiResponseDTO.setStatus(errorCode.getStatus());

            // add vào list
            result.add(apiResponseDTO);
        }

        // sv code cho chay di nhe
        // lafm xong chup anh len fb nhe
        // cac b giai lao 10p nhe
        return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<?> appEx(AppException exception) {
        ErrorCode errorCode = exception.getErrorCode();

        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setCode(errorCode.getCode());
        apiResponseDTO.setMessage(errorCode.getMessage());

        // sv lam va chup anh len fb
        return new ResponseEntity<>(apiResponseDTO, errorCode.getStatus());
    }
}
