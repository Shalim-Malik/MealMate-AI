package com.mealmate.backend.service.impl;

import com.mealmate.backend.dto.RoleRequestDTO;
import com.mealmate.backend.dto.RoleResponseDTO;
import com.mealmate.backend.entity.Role;
import com.mealmate.backend.repository.RoleRepository;
import com.mealmate.backend.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleResponseDTO saveRole(RoleRequestDTO requestDTO) {

        Role role = new Role();
        role.setRoleName(requestDTO.getRoleName());
        role.setDescription(requestDTO.getDescription());

        Role savedRole = roleRepository.save(role);

        return mapToResponse(savedRole);
    }

    @Override
    public List<RoleResponseDTO> getAllRoles() {

        return roleRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RoleResponseDTO getRoleById(Long id) {

        Role role = roleRepository.findById(id).orElse(null);

        if (role == null) {
            return null;
        }

        return mapToResponse(role);
    }

    @Override
    public RoleResponseDTO updateRole(Long id, RoleRequestDTO requestDTO) {

        Role role = roleRepository.findById(id).orElse(null);

        if (role == null) {
            return null;
        }

        role.setRoleName(requestDTO.getRoleName());
        role.setDescription(requestDTO.getDescription());

        Role updatedRole = roleRepository.save(role);

        return mapToResponse(updatedRole);
    }

    @Override
    public void deleteRole(Long id) {

        roleRepository.deleteById(id);
    }

    // Mapping Method
    private RoleResponseDTO mapToResponse(Role role) {

        RoleResponseDTO dto = new RoleResponseDTO();

        dto.setId(role.getId());
        dto.setRoleName(role.getRoleName());
        dto.setDescription(role.getDescription());

        return dto;
    }
}