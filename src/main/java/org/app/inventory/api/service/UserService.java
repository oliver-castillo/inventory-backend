package org.app.inventory.api.service;

import org.openapitools.model.NewUserRequest;
import org.openapitools.model.OperationResponse;

public interface UserService {
  OperationResponse createUser(NewUserRequest newUserRequest);
}
