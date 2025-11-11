package org.app.inventory.persistence.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "\"ROLES\"")
public class RoleEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"ID\"", nullable = false)
  private Long id;

  @Size(max = 50)
  @NotNull
  @Column(name = "\"NAME\"", nullable = false, length = 50)
  private String name;

  @NotNull
  @Column(name = "\"IS_ENABLED\"", nullable = false)
  private Boolean isEnabled = false;

  @ManyToMany(mappedBy = "roles")
  private Set<AuthorizationEntity> authorizations = new LinkedHashSet<>();

  @OneToMany(mappedBy = "role")
  private Set<UserEntity> users = new LinkedHashSet<>();

}