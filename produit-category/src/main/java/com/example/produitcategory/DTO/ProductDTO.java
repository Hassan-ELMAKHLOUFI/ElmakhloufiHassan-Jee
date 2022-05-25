package com.example.produitcategory.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String id;
    private String name;
    private double price;
    private double quantity;
    private CategoryDTO categoryDTO;
}
