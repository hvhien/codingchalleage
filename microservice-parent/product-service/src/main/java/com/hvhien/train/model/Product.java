package com.hvhien.train.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Builder
@Getter
@Setter
public class Product {
    @Id
    private String id;
    private String name;
    private Double price;
}
