package com.mealmate.backend.dto;

import lombok.Data;

@Data
public class SignupRequestDTO {

    private String fullName;

    private String email;

    private String password;

    private String confirmPassword;

    private String phoneNumber;

}