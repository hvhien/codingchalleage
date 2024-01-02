package com.hvhien.train.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateProductReqDto {
    @NotBlank
    private String name;
    @NotNull
    private Double price;
}
