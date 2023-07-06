package com.miu.waa.lab3.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.miu.waa.lab3.entity.dto.ErrorMsg;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<ErrorMsg> handleServiceException(
            ServiceException e) {
        return new ResponseEntity<>(
                new ErrorMsg(e.getCode(), e.getMessage()), e.getStatus());
    }
}
