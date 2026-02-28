package com.rodriguez_rodrigo.producer.sale.domain.exceptions;

public class SaleAlreadyExistsException extends DomainException {
    public SaleAlreadyExistsException(String message) {
        super(message);
    }
}
