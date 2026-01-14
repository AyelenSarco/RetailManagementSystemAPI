package com.example.retail.retail_management_system.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private Long id;
    private String name;
    private String brand;
    @NotNull(message = "Current price required.")
    private Double currentPrice;
    @NotNull(message="Stock required.")
    private Integer stock;

}
