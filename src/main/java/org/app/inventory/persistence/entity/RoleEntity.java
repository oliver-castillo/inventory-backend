package org.app.inventory.persistence.entity;

import jakarta.persistence.*;
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

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "\"ROLE_PERMISSIONS\"",
      joinColumns = @JoinColumn(name = "\"ROLE_ID\""),
      inverseJoinColumns = @JoinColumn(name = "\"PERMISSION_ID\"")
  )
  private Set<PermissionEntity> permissions = new LinkedHashSet<>();

  public void addPermission(PermissionEntity permission) {
    this.permissions.add(permission);
    permission.getRoles().add(this);
  }
}