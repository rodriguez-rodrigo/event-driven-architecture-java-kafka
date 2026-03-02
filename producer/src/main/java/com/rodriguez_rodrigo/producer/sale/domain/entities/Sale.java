package com.rodriguez_rodrigo.producer.sale.domain.entities;

import com.rodriguez_rodrigo.producer.core.domain.event.DomainEvent;
import com.rodriguez_rodrigo.producer.sale.domain.events.SaleCreatedEvent;
import com.rodriguez_rodrigo.producer.sale.domain.valueobjects.Description;
import com.rodriguez_rodrigo.producer.sale.domain.valueobjects.Id;
import com.rodriguez_rodrigo.producer.sale.domain.valueobjects.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

final public class Sale {
    private final Id id;
    private Description description;
    private Money amount;

    private final List<DomainEvent> domainEvents = new ArrayList<>();

    public Sale(Id id, Description description, Money name){
        this.id = Objects.requireNonNull(id);
        this.setDescription(description);
        this.setAmount(name);

        this.domainEvents.add(new SaleCreatedEvent(Id.randomId(), this));
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

    public List<DomainEvent> pullEvents(){
        List<DomainEvent> events = List.copyOf(this.domainEvents);
        domainEvents.clear();

        return events;
    }
}
