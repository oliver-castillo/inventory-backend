package org.app.inventory.domain.service;

import lombok.RequiredArgsConstructor;
import org.app.inventory.api.service.UserService;
import org.app.inventory.domain.repository.UserRepository;
import org.app.inventory.util.mapper.UserMapper;
import org.openapitools.model.NewUserRequest;
import org.openapitools.model.OperationResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DomainUserService implements UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public OperationResponse createUser(NewUserRequest newUserRequest) {
    userRepository.createUser(userMapper.requestToDomain(newUserRequest));
    return new OperationResponse();
  }
}
