package com.mealmate.backend.service.impl;

import com.mealmate.backend.repository.RoleRepository;
import com.mealmate.backend.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

}