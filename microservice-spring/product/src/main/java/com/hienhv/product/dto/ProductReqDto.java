package com.hienhv.product.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class ProductReqDto {
    private String name;
    private String skuCode;
    private int qtyNumber;
    private BigDecimal price;
}
