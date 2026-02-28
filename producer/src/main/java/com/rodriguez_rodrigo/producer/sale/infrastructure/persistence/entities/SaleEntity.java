package com.rodriguez_rodrigo.producer.sale.infrastructure.persistence.entities;

import com.rodriguez_rodrigo.producer.sale.domain.entities.Sale;
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

    public static SaleEntity fromDomain(Sale sale){
        var saleEntity = new SaleEntity();

        saleEntity.setId(sale.getId().value());
        saleEntity.setDescription(sale.getDescription().value());
        saleEntity.setAmount(sale.getAmount().value());

        return saleEntity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
