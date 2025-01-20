package com.app.inventory.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name = "role_id")
    private Set<AuthorizationEntity> authorizations;
}