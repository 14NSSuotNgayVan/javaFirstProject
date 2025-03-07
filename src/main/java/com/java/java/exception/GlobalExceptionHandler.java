package com.java.java.exception;

import com.java.java.dto.request.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<ApiResponse>handlingRuntimeException(AppException ex){
        ApiResponse res = new ApiResponse();
        ErrorCode err = ex.getErrorCode();
        res.setMessage(err.getMessage());
        res.setCode(err.getCode());
        return ResponseEntity.badRequest().body(res);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlingValidation(MethodArgumentNotValidException ex){
        ApiResponse res = new ApiResponse();
        res.setCode(400);
        res.setMessage(ex.getFieldError().getDefaultMessage());
        return ResponseEntity.badRequest().body(res);
    }
}
