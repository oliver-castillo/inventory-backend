package org.app.inventory.user.controller;

import org.openapitools.api.UsersApi;
import org.openapitools.model.NewUserRequest;
import org.openapitools.model.OperationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UsersApi {

  @Override
  public ResponseEntity<OperationResponse> createUser(NewUserRequest newUserRequest) {
    return UsersApi.super.createUser(newUserRequest);
  }
}
