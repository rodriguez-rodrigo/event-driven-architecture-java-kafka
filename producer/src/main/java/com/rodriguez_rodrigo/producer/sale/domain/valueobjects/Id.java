package com.rodriguez_rodrigo.producer.sale.domain.valueobjects;

import java.util.UUID;

public record Id(UUID value) {
    public static Id randomId() {
        return new Id(UUID.randomUUID());
    }
}
