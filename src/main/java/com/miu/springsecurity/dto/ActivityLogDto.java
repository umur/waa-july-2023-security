package com.miu.springsecurity.dto;

import lombok.Data;

import java.time.Duration;
import java.time.LocalDate;
@Data
public class ActivityLogDto {
    private int id;
    private LocalDate date;
    private String operation;
    private Duration duration;
}
