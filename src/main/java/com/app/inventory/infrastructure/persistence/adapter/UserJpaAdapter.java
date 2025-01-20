package com.app.inventory.infrastructure.persistence.adapter;

import com.app.inventory.domain.user.model.User;
import com.app.inventory.domain.user.repository.UserRepository;
import com.app.inventory.infrastructure.persistence.mapper.UserMapper;
import com.app.inventory.infrastructure.persistence.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserJpaAdapter implements UserRepository {
    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;

    @Override
    public void save(User user) {
        jpaUserRepository.save(userMapper.toEntity(user));
    }

    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAll().stream().map(userMapper::toModel).toList();
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaUserRepository.findById(id).map(userMapper::toModel);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaUserRepository.findByEmail(email).map(userMapper::toModel);
    }

    @Override
    public void deleteById(Long id) {
        jpaUserRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaUserRepository.existsById(id);
    }
}
