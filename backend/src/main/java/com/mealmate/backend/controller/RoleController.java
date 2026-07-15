package com.mealmate.backend.controller;

import com.mealmate.backend.dto.RoleRequestDTO;
import com.mealmate.backend.dto.RoleResponseDTO;
import com.mealmate.backend.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/test")
    public String test() {
        return "Role Controller Working";
    }

    @PostMapping
    public RoleResponseDTO createRole(@RequestBody RoleRequestDTO requestDTO) {
        return roleService.saveRole(requestDTO);
    }

    @GetMapping
    public List<RoleResponseDTO> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public RoleResponseDTO getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @PutMapping("/{id}")
    public RoleResponseDTO updateRole(@PathVariable Long id,
                                      @RequestBody RoleRequestDTO requestDTO) {
        return roleService.updateRole(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return "Role Deleted Successfully";
    }
}