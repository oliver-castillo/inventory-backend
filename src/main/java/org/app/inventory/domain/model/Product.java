package org.app.inventory.domain.model;

public record Product(
    Long id,
    String name,
    String description,
    Double price,
    Long businessId
) {
}
