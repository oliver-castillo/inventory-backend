package com.app.inventory.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "authorizations")
public class AuthorizationEntity extends BaseEntity {
    private String name;
}
