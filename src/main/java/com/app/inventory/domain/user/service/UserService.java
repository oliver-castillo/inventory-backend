package com.app.inventory.domain.user.service;

import com.app.inventory.domain.user.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    void updateUser(Long id, User user);

    List<User> findAll();

    User findById(Long id);

    User findByEmail(String email);

    void deleteUser(Long id);
}
