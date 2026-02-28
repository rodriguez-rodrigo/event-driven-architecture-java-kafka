package com.rodriguez_rodrigo.producer.sale.domain.repositories;

import com.rodriguez_rodrigo.producer.sale.domain.entities.Sale;

import java.util.List;

public interface SaleRepository {
    List<Sale> findAll();
    void save(Sale sale);
}
