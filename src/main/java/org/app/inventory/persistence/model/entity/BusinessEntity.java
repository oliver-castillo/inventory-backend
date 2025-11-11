package org.app.inventory.persistence.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "\"BUSINESSES\"")
public class BusinessEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"ID\"", nullable = false)
  private Long id;

  @Size(max = 50)
  @NotNull
  @Column(name = "\"NAME\"", nullable = false, length = 50)
  private String name;

  @NotNull
  @Column(name = "\"CREATED_AT\"", nullable = false)
  private Instant createdAt;

  @NotNull
  @Column(name = "\"UPDATED_AT\"", nullable = false)
  private Instant updatedAt;

  @NotNull
  @Column(name = "\"IS_ENABLED\"", nullable = false)
  private Boolean isEnabled = false;

  @OneToMany(mappedBy = "business")
  private List<ProductEntity> products = new ArrayList<>();
}