package com.rodriguez_rodrigo.producer.sale.application.requests;

import java.util.UUID;

public record MakeSaleRequest(UUID id, String description, float amount) {
}
