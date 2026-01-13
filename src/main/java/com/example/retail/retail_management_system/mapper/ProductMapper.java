package com.example.retail.retail_management_system.mapper;

import com.example.retail.retail_management_system.dto.ProductDTO;
import com.example.retail.retail_management_system.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO productDTO);
}
