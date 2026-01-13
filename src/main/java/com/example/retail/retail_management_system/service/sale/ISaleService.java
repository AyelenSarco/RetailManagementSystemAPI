package com.example.retail.retail_management_system.service.sale;

import com.example.retail.retail_management_system.dto.SaleDTO;

import java.util.List;

public interface ISaleService {

    SaleDTO createSale(SaleDTO saleDTO);
    List<SaleDTO> getSales();
    SaleDTO getSale(Long id);
    void deleteSale(Long id);
    SaleDTO updateSale(Long id, SaleDTO saleDTO);

}
