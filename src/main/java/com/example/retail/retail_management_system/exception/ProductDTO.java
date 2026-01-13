package com.example.retail.retail_management_system.exception;


import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private Long productId;
    private String name;
    private String brand;
    private Double currentPrice;
    private int stock;

}
