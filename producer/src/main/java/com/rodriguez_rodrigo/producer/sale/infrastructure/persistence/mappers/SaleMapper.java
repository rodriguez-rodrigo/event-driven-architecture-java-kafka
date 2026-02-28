package com.rodriguez_rodrigo.producer.sale.infrastructure.persistence.mappers;

import com.rodriguez_rodrigo.producer.sale.domain.entities.Sale;
import com.rodriguez_rodrigo.producer.sale.domain.valueobjects.Description;
import com.rodriguez_rodrigo.producer.sale.domain.valueobjects.Id;
import com.rodriguez_rodrigo.producer.sale.domain.valueobjects.Money;
import com.rodriguez_rodrigo.producer.sale.infrastructure.persistence.entities.SaleEntity;

public class SaleMapper {
    public static Sale toDomain(SaleEntity sale) {
        return new Sale(
                new Id(sale.getId()),
                new Description(sale.getDescription()),
                new Money(sale.getAmount())
        );
    }
}
