package org.app.inventory.persistence.repository.adapter;

import org.app.inventory.config.exception.NotFoundException;
import org.app.inventory.domain.model.User;
import org.app.inventory.persistence.entity.RoleEntity;
import org.app.inventory.persistence.entity.UserEntity;
import org.app.inventory.persistence.repository.RoleJpaRepository;
import org.app.inventory.persistence.repository.UserJpaRepository;
import org.app.inventory.util.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserJpaRepositoryAdapterTest {

  @Mock
  private UserJpaRepository userJpaRepository;

  @Mock
  private RoleJpaRepository roleJpaRepository;

  @Mock
  private UserMapper userMapper;

  @InjectMocks
  private UserJpaRepositoryAdapter userJpaRepositoryAdapterUnderTest;

  @Test
  void createUser_returnSavedUser_WhenRoleExists() {
    User user = new User();

    RoleEntity roleEntity = new RoleEntity();
    Long existingRoleId = 10L;
    roleEntity.setId(existingRoleId);

    UserEntity mapped = new UserEntity();
    mapped.setRole(roleEntity);

    UserEntity saved = new UserEntity();
    saved.setRole(roleEntity);

    when(userMapper.domainToNewEntity(any(User.class))).thenReturn(mapped);
    when(roleJpaRepository.existsById(existingRoleId)).thenReturn(true);
    when(userJpaRepository.save(mapped)).thenReturn(saved);

    UserEntity result = userJpaRepositoryAdapterUnderTest.createUser(user);

    verify(userMapper).domainToNewEntity(user);
    verify(roleJpaRepository).existsById(existingRoleId);
    assertEquals(saved, result);
  }

  @Test
  void createUser_throwNotFoundException_WhenRoleIdDoesNotExist() {
    User user = new User();

    RoleEntity roleEntity = new RoleEntity();
    Long nonExistingRoleId = 10L;
    roleEntity.setId(nonExistingRoleId);

    UserEntity mapped = new UserEntity();
    mapped.setRole(roleEntity);

    when(userMapper.domainToNewEntity(any(User.class))).thenReturn(mapped);
    when(roleJpaRepository.existsById(nonExistingRoleId)).thenReturn(false);

    verify(userJpaRepository, never()).save(any(UserEntity.class));
    assertThrows(NotFoundException.class, () -> userJpaRepositoryAdapterUnderTest.createUser(user));
  }

  @Test
  void createUser_WhenMappedRoleIsNullOrIdNull_ShouldThrowNullPointer() {
    User user = new User();

    UserEntity mapped = new UserEntity();
    // role is null -> createUser will attempt to access getRole().getId() and NPE will be thrown
    when(userMapper.domainToNewEntity(user)).thenReturn(mapped);

    assertThrows(NullPointerException.class, () -> userJpaRepositoryAdapterUnderTest.createUser(user));
  }
}
