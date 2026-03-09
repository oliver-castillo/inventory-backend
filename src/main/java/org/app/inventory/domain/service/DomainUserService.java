package org.app.inventory.domain.service;

import lombok.RequiredArgsConstructor;
import org.app.inventory.api.service.UserService;
import org.app.inventory.domain.model.User;
import org.app.inventory.domain.repository.UserRepository;
import org.app.inventory.util.mapper.UserMapper;
import org.openapitools.model.NewUserRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DomainUserService implements UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final PasswordEncoder passwordEncoder;

  @Override
  public User createUser(NewUserRequest newUserRequest) {
    User userDomain = userMapper.requestToDomain(newUserRequest);
    userDomain.setPassword(passwordEncoder.encode(newUserRequest.getPassword()));
    return userMapper.entityToDomain(userRepository.createUser(userDomain));
  }
}
