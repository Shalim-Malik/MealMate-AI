package com.mealmate.backend.service.impl;

import com.mealmate.backend.dto.UserRequestDTO;
import com.mealmate.backend.dto.UserResponseDTO;
import com.mealmate.backend.entity.Role;
import com.mealmate.backend.entity.User;
import com.mealmate.backend.exception.DuplicateEmailException;
import com.mealmate.backend.exception.DuplicatePhoneException;
import com.mealmate.backend.exception.ResourceNotFoundException;
import com.mealmate.backend.repository.RoleRepository;
import com.mealmate.backend.repository.UserRepository;
import com.mealmate.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

//    public UserServiceImpl(UserRepository userRepository,
//                           RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//
//        this.passwordEncoder = passwordEncoder;
//    }

    @Override
    public UserResponseDTO registerUser(UserRequestDTO requestDTO) {

        if (userRepository.existsByEmail(requestDTO.getEmail())) {
            throw new DuplicateEmailException("Email already exists.");
        }

        if (userRepository.existsByPhoneNumber(requestDTO.getPhoneNumber())) {
            throw new DuplicatePhoneException("Phone Number already exists.");
        }

        Role role = roleRepository.findById(requestDTO.getRoleId())
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));

        User user = new User();

        user.setFullName(requestDTO.getFullName());
        user.setEmail(requestDTO.getEmail());
        user.setPassword(passwordEncoder.encode(requestDTO.getPassword()));  // BCrypt baad me lagayenge
        user.setPhoneNumber(requestDTO.getPhoneNumber());
        user.setDateOfBirth(requestDTO.getDateOfBirth());
        user.setGender(requestDTO.getGender());
        user.setHeightCm(requestDTO.getHeightCm());
        user.setWeightKg(requestDTO.getWeightKg());
        user.setCity(requestDTO.getCity());
        user.setState(requestDTO.getState());
        user.setCountry(requestDTO.getCountry());
        user.setRole(role);

        User savedUser = userRepository.save(user);

        return mapToResponse(savedUser);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return mapToResponse(user);
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO requestDTO) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setFullName(requestDTO.getFullName());
        user.setPhoneNumber(requestDTO.getPhoneNumber());
        user.setDateOfBirth(requestDTO.getDateOfBirth());
        user.setGender(requestDTO.getGender());
        user.setHeightCm(requestDTO.getHeightCm());
        user.setWeightKg(requestDTO.getWeightKg());
        user.setCity(requestDTO.getCity());
        user.setState(requestDTO.getState());
        user.setCountry(requestDTO.getCountry());

        User updatedUser = userRepository.save(user);

        return mapToResponse(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {

        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found");
        }

        userRepository.deleteById(id);
    }

    private UserResponseDTO mapToResponse(User user) {

        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setGender(user.getGender());
        dto.setHeightCm(user.getHeightCm());
        dto.setWeightKg(user.getWeightKg());
        dto.setCity(user.getCity());
        dto.setState(user.getState());
        dto.setCountry(user.getCountry());
        dto.setEmailVerified(user.getEmailVerified());
        dto.setAccountStatus(user.getAccountStatus());

        if (user.getRole() != null) {
            dto.setRoleName(user.getRole().getRoleName());
        }

        return dto;
    }
}