package com.design.patter.cqrs.command.api.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductCommands {

    @TargetAggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
