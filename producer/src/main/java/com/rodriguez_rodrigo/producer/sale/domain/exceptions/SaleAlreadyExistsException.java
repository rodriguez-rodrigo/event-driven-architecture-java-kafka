package com.rodriguez_rodrigo.producer.sale.domain.exceptions;

import com.rodriguez_rodrigo.producer.core.domain.exceptions.DomainException;

public class SaleAlreadyExistsException extends DomainException {
    public SaleAlreadyExistsException(String message) {
        super(message);
    }
}
