package com.hvhien.order.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequestDto {
    private String orderNo;
    private String skuCode;
    private int quality;
}
