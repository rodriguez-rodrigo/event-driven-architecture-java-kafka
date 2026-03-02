package com.rodriguez_rodrigo.producer.core.infrastructure.persistence.repository;

import com.rodriguez_rodrigo.producer.core.domain.event.DomainEvent;
import com.rodriguez_rodrigo.producer.core.domain.repository.OutboxRepository;
import com.rodriguez_rodrigo.producer.core.infrastructure.persistence.entity.OutboxEventEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class JpaOutboxEventRepository implements OutboxRepository {

    private final SpringDataOutboxEventRepository repository;

    public JpaOutboxEventRepository(SpringDataOutboxEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveAll(List<DomainEvent> event) {
        var entities = event.stream().map(domainEvent -> {
            var entity = new OutboxEventEntity();

            entity.setId(UUID.randomUUID());
            entity.setAggregateId(domainEvent.getAggregateId().value());
            entity.setAggregateType(domainEvent.getAggregateType());
            entity.setEventType(domainEvent.getEventType());
            entity.setPayload(domainEvent);
            entity.setPublished(false);

            return entity;
        }).toList();

        this.repository.saveAll(entities);
    }
}
