package com.example.retail.retail_management_system.service.customer;


import com.example.retail.retail_management_system.dto.CustomerDTO;
import com.example.retail.retail_management_system.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepo;

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public List<CustomerDTO> getCustomers() {
        return List.of();
    }

    @Override
    public CustomerDTO getCustomer(Long id) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {

    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        return null;
    }
}
