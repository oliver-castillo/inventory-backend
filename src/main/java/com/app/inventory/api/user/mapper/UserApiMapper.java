package com.app.inventory.api.user.mapper;

import com.app.inventory.api.user.dto.request.UserRequest;
import com.app.inventory.api.user.dto.response.UserResponse;
import com.app.inventory.domain.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserApiMapper {
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    User toModel(UserRequest userResponse);

    @Mapping(target = "isEnabled", source = "enabled")
    UserResponse toResponse(User user);
}
