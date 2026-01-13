package com.example.retail.retail_management_system.service.customer;

import com.example.retail.retail_management_system.dto.CustomerDTO;

import java.util.List;

public interface ICustomerService {

    CustomerDTO createCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getCustomers();
    CustomerDTO getCustomer(Long id);
    void deleteCustomer(Long id);
    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);

}
