package com.mealmate.backend.service.impl;

import com.mealmate.backend.dto.LoginRequestDTO;
import com.mealmate.backend.dto.LoginResponseDTO;
import com.mealmate.backend.entity.User;
import com.mealmate.backend.repository.UserRepository;
import com.mealmate.backend.security.JwtService;
import com.mealmate.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public LoginResponseDTO login(LoginRequestDTO requestDTO) {

        User user = userRepository.findByEmail(requestDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid Email"));

        boolean isPasswordMatch = passwordEncoder.matches(
                requestDTO.getPassword(),
                user.getPassword()
        );

        if (!isPasswordMatch) {
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponseDTO(
                "Login Successful",
                token
        );
    }
}
