package com.mystore.manager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Товар
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Integer id;
    private String title;
    private String details;
}
