package org.app.inventory.persistence.repository.adapter;

import lombok.RequiredArgsConstructor;
import org.app.inventory.config.exception.NotFoundException;
import org.app.inventory.domain.model.User;
import org.app.inventory.domain.repository.UserRepository;
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
    UserEntity userEntity = userMapper.domainToNewEntity(user);
    verifyRoleExistence(userEntity.getRole().getId());
    return userJpaRepository.save(userEntity);
  }

  private void verifyRoleExistence(Long id) {
    if (!roleJpaRepository.existsById(id)) {
      throw new NotFoundException("role");
    }
  }
}
