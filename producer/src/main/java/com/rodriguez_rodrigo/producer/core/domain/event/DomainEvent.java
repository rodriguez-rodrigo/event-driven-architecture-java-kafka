package com.rodriguez_rodrigo.producer.core.domain.event;

import com.rodriguez_rodrigo.producer.sale.domain.valueobjects.Id;

public interface DomainEvent {
    Id getId();
    Id getAggregateId();
    String getAggregateType();
    String getEventType();
}
