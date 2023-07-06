package com.miu.waa.lab3.exception;

import org.springframework.http.HttpStatusCode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceException extends RuntimeException {
    private final HttpStatusCode status;
    private final String code;

    public ServiceException(HttpStatusCode status, String code, String message) {
        super(message);
        this.code = code;
        this.status = status;
    }
}
