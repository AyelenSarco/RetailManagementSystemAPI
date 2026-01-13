package com.example.retail.retail_management_system.mapper;

import com.example.retail.retail_management_system.dto.SaleDTO;
import com.example.retail.retail_management_system.model.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
            uses = SaleDetailMapper.class)
public interface SaleMapper {

    SaleDTO toDTO(Sale sale);
    Sale toEntity(SaleDTO saleDTO);
}
