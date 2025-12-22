package org.app.inventory.domain.model;

public record Business(
    Long id,
    String name,
    Boolean isEnabled
) {
}
