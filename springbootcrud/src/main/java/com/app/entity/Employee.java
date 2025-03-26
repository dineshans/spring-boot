package com.app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "emp")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;

}
