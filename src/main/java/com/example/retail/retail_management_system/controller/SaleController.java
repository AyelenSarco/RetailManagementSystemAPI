package com.example.retail.retail_management_system.controller;


import com.example.retail.retail_management_system.dto.ApiResponse;
import com.example.retail.retail_management_system.dto.ProductDTO;
import com.example.retail.retail_management_system.dto.SaleDTO;
import com.example.retail.retail_management_system.service.sale.SaleService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;

    @PostMapping("/create")
    public ResponseEntity<Object> createSale(@RequestBody SaleDTO saleDTO) {
        SaleDTO dbSaleDTO = saleService.createSale(saleDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Sale created successfully", dbSaleDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<Object>  getAllSales() {
        List<SaleDTO> salesDTO = saleService.getSales();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("Sales found", salesDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSale(@PathVariable long id) {
        SaleDTO saleDTO = saleService.getSale(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("Sale found", saleDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteSale(@PathVariable long id) {
        saleService.deleteSale(id);

        return ResponseEntity.ok("Sale deleted successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateSale(@PathVariable long id,
                                             @RequestBody SaleDTO saleDTO) {

        SaleDTO dbSaleDTO = saleService.updateSale(id, saleDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("Sale updated successfully", dbSaleDTO));
    }

    @GetMapping("/products/{saleId}")
    public ResponseEntity<Object> getProductsFromSale(@PathVariable long saleId) {

        List<ProductDTO> productDTOS = saleService.getProductsFromSale(saleId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("Products from sale with Code: " + saleId, productDTOS));
    }
}
