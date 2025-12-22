package org.app.inventory.persistence.repository.adapter;

import lombok.RequiredArgsConstructor;
import org.app.inventory.config.exception.NotFoundException;
import org.app.inventory.domain.model.User;
import org.app.inventory.domain.repository.UserRepository;
import org.app.inventory.persistence.entity.RoleEntity;
import org.app.inventory.persistence.entity.UserEntity;
import org.app.inventory.persistence.repository.RoleJpaRepository;
import org.app.inventory.persistence.repository.UserJpaRepository;
import org.app.inventory.util.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserJpaRepositoryAdapter implements UserRepository {
  private final UserJpaRepository userJpaRepository;
  private final RoleJpaRepository roleJpaRepository;
  private final UserMapper userMapper;

  @Override
  public UserEntity createUser(User user) {
    UserEntity userEntity = userMapper.domainToEntity(user);
    RoleEntity roleEntity = roleJpaRepository.findById(user.role().id().longValue())
        .orElseThrow(() -> new NotFoundException("Role"));
    userEntity.setRole(roleEntity);
    return userJpaRepository.save(userEntity);
  }
}
