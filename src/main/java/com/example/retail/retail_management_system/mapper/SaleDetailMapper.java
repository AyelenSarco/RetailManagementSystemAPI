package com.example.retail.retail_management_system.mapper;


import com.example.retail.retail_management_system.dto.SaleDetailDTO;
import com.example.retail.retail_management_system.model.SaleDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SaleDetailMapper {

    @Mapping(target="productId", source="product.productId")
    @Mapping(target="productName", source ="product.name")
    SaleDetailDTO toDTO(SaleDetail saleDetail);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "sale", ignore = true)
    SaleDetail toEntity(SaleDetailDTO saleDetailDTO);
}
