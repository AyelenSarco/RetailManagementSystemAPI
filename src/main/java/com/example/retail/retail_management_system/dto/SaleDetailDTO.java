package com.example.retail.retail_management_system.dto;


import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleDetailDTO {

    private Long id;
    private String productName;
    private int quantity;
    private Double subtotal;
    private Double unitPrice;

}
