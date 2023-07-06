package com.miu.waa.lab3.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMsg {
    private String code;
    private String message;
}
