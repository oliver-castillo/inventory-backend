package org.app.inventory.api.service;

import org.app.inventory.domain.model.User;
import org.openapitools.model.NewUserRequest;

public interface UserService {
  User createUser(NewUserRequest newUserRequest);
}
