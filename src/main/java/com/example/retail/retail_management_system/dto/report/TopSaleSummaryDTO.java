package com.example.retail.retail_management_system.dto.report;


import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopSaleSummaryDTO {

    private Long saleCode;
    private Double totalAmount;
    private Integer totalProducts;
    private String customerFirstName;
    private String customerLastName;
}
