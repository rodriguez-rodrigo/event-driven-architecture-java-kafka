package com.rodriguez_rodrigo.producer.core.infrastructure.persistence.repository;

import com.rodriguez_rodrigo.producer.core.infrastructure.persistence.entity.OutboxEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataOutboxEventRepository extends JpaRepository<OutboxEventEntity, UUID> {
}
