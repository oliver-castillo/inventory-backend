package org.app.inventory.domain.model;

import java.util.List;

public record User(
    Long id,
    String firstName,
    String lastName,
    String email,
    String password,
    Role role,
    Boolean isEnabled,
    List<Business> businesses
) {
}
