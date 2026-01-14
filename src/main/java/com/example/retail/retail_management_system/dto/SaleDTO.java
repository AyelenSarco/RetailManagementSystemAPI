package com.example.retail.retail_management_system.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleDTO {

    private Long id;
    private LocalDate saleDate;

    @NotBlank(message="Total is required.")
    private Double total;

    @NotBlank(message="Customer ID is required.")
    private Long customerId;
    private List<SaleDetailDTO> saleDetails;


}
