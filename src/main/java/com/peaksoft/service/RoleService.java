package com.peaksoft.service;
import com.peaksoft.entity.Role;
import java.util.List;

public interface RoleService {
    List<Role> getAllRole();
    Role getById(Long id);
}
