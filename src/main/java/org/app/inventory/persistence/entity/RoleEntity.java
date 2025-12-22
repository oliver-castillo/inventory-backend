package org.app.inventory.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "\"ROLE_ID\"", nullable = false)
  private Set<AuthorizationEntity> authorizations = new LinkedHashSet<>();
}