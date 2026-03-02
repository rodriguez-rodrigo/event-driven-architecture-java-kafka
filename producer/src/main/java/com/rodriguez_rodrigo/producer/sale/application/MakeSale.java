package com.rodriguez_rodrigo.producer.sale.application;

import com.rodriguez_rodrigo.producer.core.domain.repository.OutboxRepository;
import com.rodriguez_rodrigo.producer.sale.application.requests.MakeSaleRequest;
import com.rodriguez_rodrigo.producer.sale.domain.entities.Sale;
import com.rodriguez_rodrigo.producer.sale.domain.repositories.SaleRepository;
import com.rodriguez_rodrigo.producer.sale.domain.valueobjects.Description;
import com.rodriguez_rodrigo.producer.sale.domain.valueobjects.Id;
import com.rodriguez_rodrigo.producer.sale.domain.valueobjects.Money;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class MakeSale {

    private final SaleRepository saleRepository;
    private final OutboxRepository outboxRepository;

    public MakeSale(
            SaleRepository repository,
            OutboxRepository outboxRepository
    ) {
        this.saleRepository = repository;
        this.outboxRepository = outboxRepository;
    }

    @Transactional
    public void execute(MakeSaleRequest request) {
        var sale = new Sale(
                new Id(request.id()),
                new Description(request.description()),
                new Money(request.amount())
        );

        var events = sale.pullEvents();

        this.saleRepository.save(sale);
        this.outboxRepository.saveAll(events);
    }
}
