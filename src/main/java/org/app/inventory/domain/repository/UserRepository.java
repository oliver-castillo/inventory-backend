package org.app.inventory.domain.repository;

import org.app.inventory.domain.model.User;
import org.app.inventory.persistence.entity.UserEntity;

public interface UserRepository {
  UserEntity createUser(User user);
}
