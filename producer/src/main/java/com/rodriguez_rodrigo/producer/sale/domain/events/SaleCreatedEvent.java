package com.rodriguez_rodrigo.producer.sale.domain.events;

import com.rodriguez_rodrigo.producer.core.domain.event.DomainEvent;
import com.rodriguez_rodrigo.producer.sale.domain.entities.Sale;
import com.rodriguez_rodrigo.producer.sale.domain.valueobjects.Id;

public class SaleCreatedEvent implements DomainEvent {
    private final Id id;
    private final Sale sale;

    public SaleCreatedEvent(Id id,Sale sale) {
        this.id = id;
        this.sale = sale;
    }

    @Override
    public Id getId() {
        return this.id;
    }

    @Override
    public Id getAggregateId() {
        return this.sale.getId();
    }

    @Override
    public String getAggregateType() {
        return "Sale";
    }

    @Override
    public String getEventType() {
        return "SaleCreated";
    }
}
