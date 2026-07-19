package com.mealmate.backend.service;

import com.mealmate.backend.dto.LoginRequestDTO;
import com.mealmate.backend.dto.LoginResponseDTO;

public interface AuthService {

    LoginResponseDTO login(LoginRequestDTO requestDTO);

}