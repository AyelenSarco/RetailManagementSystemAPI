package com.example.retail.retail_management_system.mapper;

import com.example.retail.retail_management_system.dto.CustomerDTO;
import com.example.retail.retail_management_system.dto.ProductDTO;
import com.example.retail.retail_management_system.dto.SaleDTO;
import com.example.retail.retail_management_system.dto.SaleDetailDTO;
import com.example.retail.retail_management_system.model.Customer;
import com.example.retail.retail_management_system.model.Product;
import com.example.retail.retail_management_system.model.Sale;
import com.example.retail.retail_management_system.model.SaleDetail;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO toDTO(Customer customer);
    Customer toEntity(CustomerDTO customerDTO);

}
