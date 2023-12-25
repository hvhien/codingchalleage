package com.hvhien.train.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateProductReqDto {
    @NotB
    private String name;
    private Double price;
}
