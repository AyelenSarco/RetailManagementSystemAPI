package com.example.retail.retail_management_system.service.Product;

import com.example.retail.retail_management_system.dto.ProductDTO;
import com.example.retail.retail_management_system.model.Product;

import java.util.List;

public interface IProductService {

    ProductDTO createProduct(ProductDTO productDTO);
    List<ProductDTO> getProducts();
    Product getProductById(Long id);
    void deleteProduct(Long id);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
}
