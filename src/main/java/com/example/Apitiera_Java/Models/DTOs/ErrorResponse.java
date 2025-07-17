package com.example.Apitiera_Java.Models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponse {
    public int status;
    public String message;
}
