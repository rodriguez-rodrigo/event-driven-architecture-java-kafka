package com.rodriguez_rodrigo.producer.interfaces.rest.v1.advice;

import com.rodriguez_rodrigo.producer.interfaces.rest.v1.dto.ErrorResponse;
import com.rodriguez_rodrigo.producer.sale.domain.exceptions.SaleAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SaleExceptionHandler {

    @ExceptionHandler(SaleAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handle (SaleAlreadyExistsException exception){

        var statusCode = HttpStatus.BAD_REQUEST;

        return ResponseEntity
                .status(statusCode)
                .body(new ErrorResponse(exception.getMessage(), statusCode.value()));
    }
}
