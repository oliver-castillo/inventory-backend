package com.app.inventory.api.user.dto.response;

public record UserResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        boolean isEnabled
) {
}