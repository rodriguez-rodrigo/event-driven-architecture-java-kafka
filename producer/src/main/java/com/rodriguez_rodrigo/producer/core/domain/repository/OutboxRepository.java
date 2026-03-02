package com.rodriguez_rodrigo.producer.core.domain.repository;

import com.rodriguez_rodrigo.producer.core.domain.event.DomainEvent;

import java.util.List;

public interface OutboxRepository {
    void saveAll(List<DomainEvent> event);
}
