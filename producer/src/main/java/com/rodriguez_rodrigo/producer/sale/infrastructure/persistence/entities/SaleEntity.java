package com.rodriguez_rodrigo.producer.sale.infrastructure.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "sales")
public class SaleEntity {
    @Id
    private UUID id;
    private String description;
    private float amount;

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public float getAmount() {
        return amount;
    }
}
