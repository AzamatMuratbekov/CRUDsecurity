package com.peaksoft.service;

import com.peaksoft.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user,Long roleId);
    void update(Long id,User user);
    User getById(Long id);
    List<User>getAll();
    User getUserByUserName(String email);
}
