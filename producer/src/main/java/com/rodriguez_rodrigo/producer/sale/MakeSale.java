package com.rodriguez_rodrigo.producer.sale;

import com.rodriguez_rodrigo.producer.sale.application.requests.MakeSaleRequest;
import com.rodriguez_rodrigo.producer.sale.domain.entities.Sale;
import com.rodriguez_rodrigo.producer.sale.domain.repositories.SaleRepository;
import com.rodriguez_rodrigo.producer.sale.domain.valueobjects.Description;
import com.rodriguez_rodrigo.producer.sale.domain.valueobjects.Id;
import com.rodriguez_rodrigo.producer.sale.domain.valueobjects.Money;
import org.springframework.stereotype.Service;

@Service
public class MakeSale {

    private final SaleRepository repository;

    public MakeSale(SaleRepository repository) {
        this.repository = repository;
    }

    public void execute(MakeSaleRequest request){
        this.repository.save(new Sale(
                new Id(request.id()),
                new Description(request.description()),
                new Money(request.amount())
        ));
    }
}
