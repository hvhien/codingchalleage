package com.hvhien.train.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResDto {
    private String name;
    private Double price;
}
