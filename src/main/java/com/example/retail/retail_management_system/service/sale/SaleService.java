package com.example.retail.retail_management_system.service.sale;

import com.example.retail.retail_management_system.dto.SaleDTO;
import com.example.retail.retail_management_system.exception.NotFoundException;
import com.example.retail.retail_management_system.mapper.SaleMapper;
import com.example.retail.retail_management_system.model.Customer;
import com.example.retail.retail_management_system.model.Sale;
import com.example.retail.retail_management_system.repository.ICustomerRepository;
import com.example.retail.retail_management_system.repository.ISaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SaleService implements ISaleService {

    private final ISaleRepository saleRepo;
    private final ICustomerRepository customerRepo;
    private final SaleMapper saleMapper;

    @Override
    public SaleDTO createSale(SaleDTO saleDTO) {

        Customer customer = customerRepo.findById(saleDTO.getCustomerId()).orElseThrow(
                () -> new NotFoundException("Customer not found")
        );

        Sale sale = saleMapper.toEntity(saleDTO, customer);
        return saleMapper.toDTO(saleRepo.save(sale));

    }

    @Override
    public List<SaleDTO> getSales() {

        return saleRepo.findAll().stream()
                .map(saleMapper::toDTO)
                .toList();
    }

    @Override
    public SaleDTO getSale(Long id) {
        Sale sale = saleRepo.findById(id).orElseThrow(() -> new NotFoundException("Sale not found"));
        return saleMapper.toDTO(sale);
    }

    @Override
    public void deleteSale(Long id) {
        if (!saleRepo.existsById(id)) {
            throw new NotFoundException("Sale not found");
        }

        saleRepo.deleteById(id);
    }

    @Override
    public SaleDTO updateSale(Long id, SaleDTO saleDTO) {
        return null;
    }
}
