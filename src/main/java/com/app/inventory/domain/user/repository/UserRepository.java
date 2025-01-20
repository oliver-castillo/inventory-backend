package com.app.inventory.domain.user.repository;

import com.app.inventory.domain.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);

    List<User> findAll();

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    void deleteById(Long id);

    boolean existsById(Long id);
}
