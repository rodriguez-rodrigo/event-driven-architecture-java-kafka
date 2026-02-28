package com.rodriguez_rodrigo.producer.sale.domain.entities;

import com.rodriguez_rodrigo.producer.sale.domain.valueobjects.Description;
import com.rodriguez_rodrigo.producer.sale.domain.valueobjects.Id;
import com.rodriguez_rodrigo.producer.sale.domain.valueobjects.Money;

import java.util.Objects;

final public class Sale {
    private final Id id;
    private Description description;
    private Money amount;

    public Sale(Id id, Description description, Money name){
        this.id = Objects.requireNonNull(id);
        this.setDescription(description);
        this.setAmount(name);
    }

    public Id getId(){
        return id;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = Objects.requireNonNull(description);
    }

    public Money getAmount(){
        return amount;
    }

    public void setAmount(Money amount){
        this.amount = Objects.requireNonNull(amount);
    }
}
