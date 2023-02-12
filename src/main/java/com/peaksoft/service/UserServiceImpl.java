package com.peaksoft.service;
import com.peaksoft.entity.Role;
import com.peaksoft.entity.User;
import com.peaksoft.repository.RoleRepository;
import com.peaksoft.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Override
    public void addUser(User user,Long roleId) {
        user.setPassword(encoder.encode(user.getPassword()));
        Role role = roleRepository.getById(roleId);
        Set<Role>roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
    }
    @Override
    public void update(Long id, User user) {
        User user1 = userRepository.getById(id);
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setRoles(user.getRoles());
        userRepository.save(user1);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUserName(String email) {
        return userRepository.getUserByEmail(email);
    }
}
