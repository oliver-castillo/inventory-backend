package org.app.inventory.domain.service;

import org.app.inventory.domain.model.User;
import org.app.inventory.domain.repository.UserRepository;
import org.app.inventory.persistence.entity.UserEntity;
import org.app.inventory.util.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.NewUserRequest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DomainServiceTest {
  @Mock
  private UserRepository userRepository;

  @Mock
  private UserMapper userMapper;

  @InjectMocks
  private DomainUserService domainUserServiceUnderTest;

  /*// 1) Should map request to domain and persist via repository
  @org.junit.jupiter.api.Test
  void createUser_shouldMapAndPersist() {
    org.openapitools.model.NewUserRequest req = new org.openapitools.model.NewUserRequest();
    org.app.inventory.domain.model.User domain = new org.app.inventory.domain.model.User();

    org.mockito.Mockito.when(userMapper.requestToDomain(req)).thenReturn(domain);

    org.openapitools.model.OperationResponse resp = domainUserServiceUnderTest.createUser(req);

    org.mockito.Mockito.verify(userMapper).requestToDomain(req);
    org.mockito.Mockito.verify(userRepository).createUser(domain);
    org.junit.jupiter.api.Assertions.assertEquals(
        org.app.inventory.util.message.OperationMessage.CREATED.getMessage(), resp.getMessage());
  }

  // 2) Should propagate runtime exceptions from mapper
  @org.junit.jupiter.api.Test
  void createUser_shouldPropagateMapperException() {
    org.openapitools.model.NewUserRequest req = new org.openapitools.model.NewUserRequest();
    RuntimeException boom = new RuntimeException("mapper failed");
    org.mockito.Mockito.when(userMapper.requestToDomain(req)).thenThrow(boom);

    org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class,
        () -> domainUserServiceUnderTest.createUser(req));

    org.mockito.Mockito.verify(userRepository, org.mockito.Mockito.never())
        .createUser(org.mockito.ArgumentMatchers.any());
  }

  // 3) Should propagate runtime exceptions from repository
  @org.junit.jupiter.api.Test
  void createUser_shouldPropagateRepositoryException() {
    org.openapitools.model.NewUserRequest req = new org.openapitools.model.NewUserRequest();
    org.app.inventory.domain.model.User domain = new org.app.inventory.domain.model.User();
    org.mockito.Mockito.when(userMapper.requestToDomain(req)).thenReturn(domain);
    RuntimeException boom = new RuntimeException("repo failed");
    org.mockito.Mockito.doThrow(boom).when(userRepository).createUser(domain);

    org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class,
        () -> domainUserServiceUnderTest.createUser(req));
  }

  // 4) Should return CREATED message regardless of repository return type (void)
  @org.junit.jupiter.api.Test
  void createUser_shouldReturnCreatedMessage() {
    org.openapitools.model.NewUserRequest req = new org.openapitools.model.NewUserRequest();
    org.app.inventory.domain.model.User domain = new org.app.inventory.domain.model.User();
    org.mockito.Mockito.when(userMapper.requestToDomain(req)).thenReturn(domain);

    org.openapitools.model.OperationResponse resp = domainUserServiceUnderTest.createUser(req);

    org.junit.jupiter.api.Assertions.assertNotNull(resp);
    org.junit.jupiter.api.Assertions.assertEquals(
        org.app.inventory.util.message.OperationMessage.CREATED.getMessage(), resp.getMessage());
  }

  // 5) Should handle null request by passing it to mapper and behaving accordingly
  @org.junit.jupiter.api.Test
  void createUser_withNullRequest_passesToMapper() {
    org.mockito.Mockito.when(userMapper.requestToDomain(null))
        .thenReturn(new org.app.inventory.domain.model.User());

    org.openapitools.model.OperationResponse resp = domainUserServiceUnderTest.createUser(null);

    org.mockito.Mockito.verify(userMapper).requestToDomain(null);
    org.mockito.Mockito.verify(userRepository)
        .createUser(org.mockito.ArgumentMatchers.any(org.app.inventory.domain.model.User.class));
    org.junit.jupiter.api.Assertions.assertEquals(
        org.app.inventory.util.message.OperationMessage.CREATED.getMessage(), resp.getMessage());
  }*/

  @Test
  void createUser_persistUser_whenDataIsMapped() {
    NewUserRequest newUserRequest = new NewUserRequest();
    User user = new User();
    UserEntity saved = new UserEntity();

    when(userMapper.requestToDomain(any(NewUserRequest.class))).thenReturn(user);
    when(userRepository.createUser(user)).thenReturn(saved);

    domainUserServiceUnderTest.createUser(newUserRequest);


  }
}
