package com.example.retail.retail_management_system.mapper;

import com.example.retail.retail_management_system.dto.SaleDTO;
import com.example.retail.retail_management_system.model.Customer;
import com.example.retail.retail_management_system.model.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
            uses = SaleDetailMapper.class)
public interface SaleMapper {

    SaleDTO toDTO(Sale sale);

    @Mapping(target = "id", ignore = true)
    @Mapping(target="customer", source="customer")
    Sale toEntity(SaleDTO saleDTO, Customer customer);
}
