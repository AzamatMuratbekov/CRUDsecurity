package com.peaksoft.service.impl;

import com.peaksoft.entity.Role;
import com.peaksoft.repository.RoleRepository;
import com.peaksoft.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RoleServiceImpl  implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public Role getById(Long id) {
        return roleRepository.findById(id).get();
    }
}
