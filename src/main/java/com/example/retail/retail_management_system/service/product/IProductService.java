package com.example.retail.retail_management_system.service.product;

import com.example.retail.retail_management_system.dto.ProductDTO;

import java.util.List;

public interface IProductService {

    ProductDTO createProduct(ProductDTO productDTO);
    List<ProductDTO> getProducts();
    ProductDTO getProductById(Long id);
    void deleteProduct(Long id);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
}
