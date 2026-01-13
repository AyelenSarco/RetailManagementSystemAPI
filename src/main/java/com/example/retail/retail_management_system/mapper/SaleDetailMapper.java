package com.example.retail.retail_management_system.mapper;


import com.example.retail.retail_management_system.dto.SaleDetailDTO;
import com.example.retail.retail_management_system.model.SaleDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleDetailMapper {

    SaleDetailDTO toDTO(SaleDetail saleDetail);
    SaleDetail toEntity(SaleDetailDTO saleDetailDTO);
}
