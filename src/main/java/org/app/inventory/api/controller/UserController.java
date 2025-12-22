package org.app.inventory.api.controller;

import lombok.RequiredArgsConstructor;
import org.app.inventory.api.service.UserService;
import org.openapitools.api.UsersApi;
import org.openapitools.model.NewUserRequest;
import org.openapitools.model.OperationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UsersApi {
  private final UserService userService;

  @Override
  public ResponseEntity<OperationResponse> createUser(NewUserRequest newUserRequest) {
    return new ResponseEntity<>(userService.createUser(newUserRequest), HttpStatus.CREATED);
  }
}
