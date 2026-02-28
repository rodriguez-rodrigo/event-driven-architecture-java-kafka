package com.rodriguez_rodrigo.producer.interfaces.rest.v1;

import com.rodriguez_rodrigo.producer.sale.MakeSale;
import com.rodriguez_rodrigo.producer.sale.application.GetSales;
import com.rodriguez_rodrigo.producer.sale.application.dto.SaleDto;
import com.rodriguez_rodrigo.producer.sale.application.requests.MakeSaleRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {

    private final GetSales getUsersUseCase;
    private final MakeSale makeSaleUseCase;

    public SaleController(GetSales getUsersUseCase, MakeSale makeSaleUseCase) {
        this.getUsersUseCase = getUsersUseCase;
        this.makeSaleUseCase = makeSaleUseCase;
    }

    @GetMapping
    public List<SaleDto> getSales() {
        return this.getUsersUseCase.execute();
    }

    @PostMapping
    public ResponseEntity<Void> makeSale(
            @RequestBody MakeSaleRequest request
    ) {
        this.makeSaleUseCase.execute(request);

        return ResponseEntity
                .created(URI.create("/api/v1/sales/"+ request.id().toString()))
                .build();
    }
}
