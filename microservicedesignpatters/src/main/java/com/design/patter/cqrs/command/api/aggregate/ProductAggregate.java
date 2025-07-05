package com.design.patter.cqrs.command.api.aggregate;

import com.design.patter.cqrs.command.api.commands.CreateProductCommands;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    public ProductAggregate() {

    }

    public ProductAggregate(CreateProductCommands createProductCommands) {

    }
}
