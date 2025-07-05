package com.design.patter.cqrs.command.api.controller;

import com.design.patter.cqrs.command.api.commands.CreateProductCommands;
import com.design.patter.cqrs.command.api.model.ProductModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController("/products")
public class ProductCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody ProductModel productModel) {
        CreateProductCommands createProductCommands =
                CreateProductCommands.builder()
                        .productId(UUID.randomUUID().toString())
                        .name(productModel.getName())
                        .price(productModel.getPrice())
                        .quantity(productModel.getQuantity())
                        .build();
        String result = commandGateway.sendAndWait(createProductCommands);
        return ResponseEntity.ok(result);
    }
}
