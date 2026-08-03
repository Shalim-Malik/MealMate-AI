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
import com.mealmate.backend.dto.SignupRequestDTO;
import com.mealmate.backend.dto.SignupResponseDTO;
import com.mealmate.backend.entity.Role;
import com.mealmate.backend.repository.RoleRepository;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final RoleRepository roleRepository;

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
    @Override
    public SignupResponseDTO signup(SignupRequestDTO requestDTO) {

        if (userRepository.existsByEmail(requestDTO.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        if (userRepository.existsByPhoneNumber(requestDTO.getPhoneNumber())) {
            throw new RuntimeException("Phone number already exists");
        }

        if (!requestDTO.getPassword().equals(requestDTO.getConfirmPassword())) {
            throw new RuntimeException("Passwords do not match");
        }

        User user = new User();

        user.setFullName(requestDTO.getFullName());

        user.setEmail(requestDTO.getEmail());

        user.setPassword(
                passwordEncoder.encode(requestDTO.getPassword())
        );

        user.setPhoneNumber(requestDTO.getPhoneNumber());
        Role userRole = roleRepository.findByRoleName("USER")
                .orElseThrow(() -> new RuntimeException("USER role not found"));

        user.setRole(userRole);

        userRepository.save(user);
        return new SignupResponseDTO(
                "Signup Successful"
        );

    }
}
