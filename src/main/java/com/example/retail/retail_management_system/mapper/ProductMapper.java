package com.example.retail.retail_management_system.mapper;

import com.example.retail.retail_management_system.dto.ProductDTO;
import com.example.retail.retail_management_system.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target="id", source="productId")
    ProductDTO toDTO(Product product);

    Product toEntity(ProductDTO productDTO);
}
