package com.app.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private int id;
    private String name;
    private String category;
    private String color;
    // To not generate setter for specific fields - @Setter(AccessLevel.NONE) / @Getter(AccessLevel.NONE)
    private double price;
}
