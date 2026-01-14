package com.example.retail.retail_management_system.dto.report;


import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DailySalesSummaryDTO {

    private LocalDate date;
    private Double totalAmount;
    private Integer totalSaleCount;

}
