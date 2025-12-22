package org.app.inventory.util.mapper;

import org.app.inventory.domain.model.User;
import org.app.inventory.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;
import org.openapitools.model.NewUserRequest;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @Mapping(target = "id", ignore = true)
  UserEntity domainToNewEntity(User user);

  @Mapping(target = "role.id", source = "roleId")
  User requestToDomain(NewUserRequest newUserRequest);

  UserEntity domainToEntity(User user);

  User entityToDomain(UserEntity userEntity);
}
