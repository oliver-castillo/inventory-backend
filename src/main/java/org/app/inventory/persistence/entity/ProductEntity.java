package org.app.inventory.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"PRODUCTS\"")
public class ProductEntity extends AuditableEntity {
  @Size(max = 100)
  @NotNull
  @Column(name = "\"NAME\"", nullable = false, length = 100)
  private String name;

  @NotNull
  @Column(name = "\"IS_ENABLED\"", nullable = false)
  private Boolean isEnabled = false;

}