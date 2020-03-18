package com.example.usermanagementrestapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private int productId;

    private int categoryId;

    private String name;

    private String thumbnail;

    private String description;

    private int stockAmount;

    private float price;
}
