package com.app.inventory.infrastructure.persistence.mapper;

import com.app.inventory.domain.user.model.User;
import com.app.inventory.infrastructure.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(User user);

    User toModel(UserEntity userEntity);
}
