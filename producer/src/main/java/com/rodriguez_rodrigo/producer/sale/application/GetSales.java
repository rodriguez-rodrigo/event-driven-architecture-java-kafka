package com.rodriguez_rodrigo.producer.sale.application;

import com.rodriguez_rodrigo.producer.sale.application.dto.SaleDto;
import com.rodriguez_rodrigo.producer.sale.domain.repositories.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetSales {

    SaleRepository repository;

    public GetSales(SaleRepository userRepository) {
        this.repository = userRepository;
    }

    public List<SaleDto> execute() {
        return this.repository.findAll()
                .stream()
                .map(sale -> new SaleDto(
                        sale.getId().value().toString(),
                        sale.getDescription().value(),
                        sale.getAmount().value()
                ))
                .toList();
    }
}
