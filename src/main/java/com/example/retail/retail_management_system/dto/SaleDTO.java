package com.example.retail.retail_management_system.dto;


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
    private Double total;
    private Long customerId;
    private List<SaleDetailDTO> saleDetails;


}
