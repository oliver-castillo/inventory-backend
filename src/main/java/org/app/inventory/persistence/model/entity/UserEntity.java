package org.app.inventory.persistence.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"USERS\"")
public class UserEntity extends AuditableEntity {
  @Size(max = 50)
  @NotNull
  @Column(name = "\"FIRST_NAME\"", nullable = false, length = 50)
  private String firstName;

  @Size(max = 50)
  @NotNull
  @Column(name = "\"LAST_NAME\"", nullable = false, length = 50)
  private String lastName;

  @Size(max = 255)
  @NotNull
  @Column(name = "\"EMAIL\"", nullable = false)
  private String email;

  @Size(max = 255)
  @NotNull
  @Column(name = "\"PASSWORD\"", nullable = false)
  private String password;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "\"ROLE_ID\"", nullable = false)
  private RoleEntity role;

  @NotNull
  @Column(name = "\"IS_ENABLED\"", nullable = false)
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private Boolean isEnabled = false;

  public boolean isEnabled() {
    return this.isEnabled;
  }

  public void isEnabled(Boolean isEnabled) {
    this.isEnabled = isEnabled;
  }
}