package org.app.inventory.persistence.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "\"PRODUCTS\"")
public class ProductEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"ID\"", nullable = false)
  private Long id;

  @Size(max = 100)
  @NotNull
  @Column(name = "\"NAME\"", nullable = false, length = 100)
  private String name;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "\"BUSINESS_ID\"", nullable = false)
  private BusinessEntity business;

  @NotNull
  @Column(name = "\"CREATED_AT\"", nullable = false)
  private Instant createdAt;

  @NotNull
  @Column(name = "\"UPDATED_AT\"", nullable = false)
  private Instant updatedAt;

  @NotNull
  @Column(name = "\"IS_ENABLED\"", nullable = false)
  private Boolean isEnabled = false;

}