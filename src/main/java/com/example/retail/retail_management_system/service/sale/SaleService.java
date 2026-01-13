package com.example.retail.retail_management_system.service.sale;

import com.example.retail.retail_management_system.dto.SaleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService implements ISaleService {
    @Override
    public SaleDTO createSale(SaleDTO saleDTO) {
        return null;
    }

    @Override
    public List<SaleDTO> getSales() {
        return List.of();
    }

    @Override
    public SaleDTO getSale(Long id) {
        return null;
    }

    @Override
    public void deleteSale(Long id) {

    }

    @Override
    public SaleDTO updateSale(Long id, SaleDTO saleDTO) {
        return null;
    }
}
