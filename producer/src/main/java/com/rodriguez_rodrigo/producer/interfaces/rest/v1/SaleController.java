package com.rodriguez_rodrigo.producer.interfaces.rest.v1;

import com.rodriguez_rodrigo.producer.sale.application.GetSales;
import com.rodriguez_rodrigo.producer.sale.application.dto.SaleDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {

    private final GetSales getUsersUseCase;

    public SaleController(GetSales getUsersUseCase){
        this.getUsersUseCase = getUsersUseCase;
    }

    @GetMapping
    public List<SaleDto> getSales() {
        return this.getUsersUseCase.execute();
    }
}
