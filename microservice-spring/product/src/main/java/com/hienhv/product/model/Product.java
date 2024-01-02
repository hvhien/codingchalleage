package com.hienhv.product.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "product")
public class Product {
    @Id
    private String id;
    private String skuCode;
    private String name;
    private int qtyNo;
    private BigDecimal price;
}
