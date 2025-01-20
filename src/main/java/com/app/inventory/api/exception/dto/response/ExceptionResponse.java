package com.app.inventory.api.exception.dto.response;

public record ExceptionResponse(
        String message,
        Integer status
) {
}
