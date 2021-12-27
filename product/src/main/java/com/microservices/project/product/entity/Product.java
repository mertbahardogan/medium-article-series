package com.microservices.project.product.entity;

import org.springframework.data.annotation.Id;
import java.math.BigDecimal;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
