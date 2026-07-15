package com.mealmate.backend.service;

import com.mealmate.backend.dto.RoleRequestDTO;
import com.mealmate.backend.dto.RoleResponseDTO;

import java.util.List;

public interface RoleService {

    RoleResponseDTO saveRole(RoleRequestDTO requestDTO);

    List<RoleResponseDTO> getAllRoles();

    RoleResponseDTO getRoleById(Long id);

    RoleResponseDTO updateRole(Long id, RoleRequestDTO requestDTO);

    void deleteRole(Long id);
}