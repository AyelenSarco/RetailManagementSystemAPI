package com.example.retail.retail_management_system.service.sale;

import com.example.retail.retail_management_system.dto.report.DailySalesSummaryDTO;
import com.example.retail.retail_management_system.dto.ProductDTO;
import com.example.retail.retail_management_system.dto.SaleDTO;
import com.example.retail.retail_management_system.dto.report.TopSaleSummaryDTO;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {

    SaleDTO createSale(SaleDTO saleDTO);
    List<SaleDTO> getSales();
    SaleDTO getSale(Long id);
    void deleteSale(Long id);
    SaleDTO updateSale(Long id, SaleDTO saleDTO);

    List<ProductDTO> getProductsFromSale(Long id);

    DailySalesSummaryDTO getDailySalesSummary(LocalDate date);

    TopSaleSummaryDTO getTopSaleSummary();


}
