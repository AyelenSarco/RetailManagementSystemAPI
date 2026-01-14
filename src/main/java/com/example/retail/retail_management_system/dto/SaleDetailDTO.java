package com.example.retail.retail_management_system.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleDetailDTO {

    private Long id;

    @NotBlank (message = "Product Id is required")
    private Long productId;

    private String productName;
    private int quantity;
    private Double subtotal;
    private Double unitPrice;

}
