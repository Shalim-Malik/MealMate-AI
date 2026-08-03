package com.mealmate.backend.service;

import com.mealmate.backend.dto.LoginRequestDTO;
import com.mealmate.backend.dto.LoginResponseDTO;
import com.mealmate.backend.dto.SignupRequestDTO;
import com.mealmate.backend.dto.SignupResponseDTO;

public interface AuthService {

    LoginResponseDTO login(LoginRequestDTO requestDTO);
    SignupResponseDTO signup(SignupRequestDTO requestDTO);

}