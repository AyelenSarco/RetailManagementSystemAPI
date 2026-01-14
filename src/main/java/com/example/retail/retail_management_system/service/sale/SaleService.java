package com.example.retail.retail_management_system.service.sale;

import com.example.retail.retail_management_system.dto.SaleDTO;
import com.example.retail.retail_management_system.dto.SaleDetailDTO;
import com.example.retail.retail_management_system.exception.InsufficientStockException;
import com.example.retail.retail_management_system.exception.NotFoundException;
import com.example.retail.retail_management_system.mapper.SaleDetailMapper;
import com.example.retail.retail_management_system.mapper.SaleMapper;
import com.example.retail.retail_management_system.model.Customer;
import com.example.retail.retail_management_system.model.Product;
import com.example.retail.retail_management_system.model.Sale;
import com.example.retail.retail_management_system.model.SaleDetail;
import com.example.retail.retail_management_system.repository.ICustomerRepository;
import com.example.retail.retail_management_system.repository.IProductRepository;
import com.example.retail.retail_management_system.repository.ISaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SaleService implements ISaleService {

    private final ISaleRepository saleRepo;
    private final ICustomerRepository customerRepo;
    private final IProductRepository productRepo;
    private final SaleMapper saleMapper;
    private final SaleDetailMapper saleDetailMapper;

    @Override
    public SaleDTO createSale(SaleDTO saleDTO) {

        Customer customer = customerRepo.findById(saleDTO.getCustomerId()).orElseThrow(
                () -> new NotFoundException("Customer not found")
        );

        Sale sale = saleMapper.toEntity(saleDTO);
        sale.setCustomer(customer);
        sale.setSaleDate(LocalDate.now());

        List<SaleDetail> details = new ArrayList<>();
        Product product;
        SaleDetail saleDetail;

        for (SaleDetailDTO detailDTO : saleDTO.getSaleDetails()) {
            product = productRepo.findById(detailDTO.getProductId())
                    .orElseThrow(() -> new NotFoundException("Product not found"));

            saleDetail = saleDetailMapper.toEntity(detailDTO);

            if (product.getStock() < saleDetail.getQuantity() ) {
                throw new InsufficientStockException("Not enough stock available for product:" + product.getName());
            }

            product.setStock( product.getStock() - saleDetail.getQuantity());

            saleDetail.setProduct(product);
            saleDetail.setSale(sale);

            details.add(saleDetail);
        }

        sale.setSaleDetails(details);

        SaleDTO dbSaleDTO = saleMapper.toDTO(saleRepo.save(sale));

        return dbSaleDTO;

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

    // Update sale data only (no sale details affected).
    @Override
    public SaleDTO updateSale(Long id, SaleDTO saleDTO) {

        Sale sale = saleRepo.findById(id).orElseThrow(() -> new NotFoundException("Sale not found"));

        if (saleDTO.getSaleDate() != null) {
            sale.setSaleDate(saleDTO.getSaleDate());
        }
        if (saleDTO.getTotal() != null) {
            sale.setTotal(saleDTO.getTotal());
        }
        saleRepo.save(sale);

        return saleMapper.toDTO(sale);

    }
}
