package com.rodriguez_rodrigo.producer.interfaces.rest.v1.dto;

import java.time.LocalDateTime;

public record ErrorResponse(String message, int status, LocalDateTime timestamp) {
    public ErrorResponse(String message, int status){
        this(message, status, LocalDateTime.now());
    }
}
