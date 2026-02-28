package com.rodriguez_rodrigo.producer.sale.infrastructure.persistence.repositories;

import com.rodriguez_rodrigo.producer.sale.domain.entities.Sale;
import com.rodriguez_rodrigo.producer.sale.domain.exceptions.SaleAlreadyExistsException;
import com.rodriguez_rodrigo.producer.sale.domain.repositories.SaleRepository;
import com.rodriguez_rodrigo.producer.sale.infrastructure.persistence.entities.SaleEntity;
import com.rodriguez_rodrigo.producer.sale.infrastructure.persistence.mappers.SaleMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SaleRepositoryImpl implements SaleRepository
{
    private final SpringDataSaleRepository repository;

    public SaleRepositoryImpl(SpringDataSaleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Sale> findAll() {
        return this.repository.findAll()
                .stream()
                .map(SaleMapper::toDomain)
                .toList();
    }

    @Override
    public void save(Sale sale) {
        if(this.repository.existsById(sale.getId().value())) {
            throw new SaleAlreadyExistsException("Sale with id " + sale.getId() + " already exists");
        }

        var saleEntity = SaleEntity.fromDomain(sale);

        this.repository.save(saleEntity);
    }
}
