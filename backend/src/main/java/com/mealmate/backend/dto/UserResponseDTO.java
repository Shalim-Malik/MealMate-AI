package com.mealmate.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {

    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String gender;
    private Double heightCm;
    private Double weightKg;
    private String city;
    private String state;
    private String country;
    private Boolean emailVerified;
    private String accountStatus;
    private String roleName;
}