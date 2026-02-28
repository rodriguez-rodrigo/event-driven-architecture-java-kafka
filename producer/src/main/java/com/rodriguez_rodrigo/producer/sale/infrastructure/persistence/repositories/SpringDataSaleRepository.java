package com.rodriguez_rodrigo.producer.sale.infrastructure.persistence.repositories;

import com.rodriguez_rodrigo.producer.sale.infrastructure.persistence.entities.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataSaleRepository extends JpaRepository<SaleEntity, UUID> {
}
