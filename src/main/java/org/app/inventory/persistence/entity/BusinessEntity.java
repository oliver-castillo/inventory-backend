package org.app.inventory.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "\"BUSINESSES\"")
public class BusinessEntity extends AuditableEntity {
  @Size(max = 50)
  @NotNull
  @Column(name = "\"NAME\"", nullable = false, length = 50)
  private String name;

  @NotNull
  @Column(name = "\"IS_ENABLED\"", nullable = false)
  private Boolean isEnabled = true;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "\"BUSINESS_ID\"", nullable = false)
  private List<ProductEntity> products = new ArrayList<>();
}