package org.app.inventory.api.controller;

import lombok.RequiredArgsConstructor;
import org.app.inventory.api.service.UserService;
import org.app.inventory.util.mapper.UserMapper;
import org.openapitools.api.UsersApi;
import org.openapitools.model.NewUserRequest;
import org.openapitools.model.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UsersApi {
  private final UserService userService;
  private final UserMapper userMapper;

  @Override
  public ResponseEntity<UserResponse> createUser(NewUserRequest newUserRequest) {
    return new ResponseEntity<>(userMapper.domainToResponse(
        userService.createUser(newUserRequest)), HttpStatus.CREATED);
  }
}
