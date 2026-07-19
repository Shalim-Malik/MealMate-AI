package com.mealmate.backend.controller;

import com.mealmate.backend.dto.LoginRequestDTO;
import com.mealmate.backend.dto.LoginResponseDTO;
import com.mealmate.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO requestDTO) {
        return authService.login(requestDTO);
    }
}