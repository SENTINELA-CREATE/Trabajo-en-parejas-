package com.example.trabajo_evaluativo.dto;

import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProductInputDTO {
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private String category;
}
