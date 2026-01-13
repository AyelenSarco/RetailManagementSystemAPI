package com.example.retail.retail_management_system.service.customer;


import com.example.retail.retail_management_system.dto.CustomerDTO;
import com.example.retail.retail_management_system.exception.NotFoundException;
import com.example.retail.retail_management_system.mapper.CustomerMapper;
import com.example.retail.retail_management_system.model.Customer;
import com.example.retail.retail_management_system.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepo;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {

        Customer customer = customerRepo.save(customerMapper.toEntity(customerDTO));
        return customerMapper.toDTO(customer);
    }

    @Override
    public List<CustomerDTO> getCustomers() {
        return customerRepo.findAll().stream()
                .map(customerMapper::toDTO)
                .toList();
    }

    @Override
    public CustomerDTO getCustomer(Long id) {

        Customer customer = customerRepo.findById(id).orElseThrow(() -> new NotFoundException("Customer not found"));
        return customerMapper.toDTO(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        if (!customerRepo.existsById(id)) {
            throw new NotFoundException("Customer not found");
        }
        customerRepo.deleteById(id);
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {

        Customer  dbCustomer = customerRepo.findById(id).orElseThrow(() -> new NotFoundException("Customer not found"));

        if (customerDTO.getFirstName() != null) {
            dbCustomer.setFirstName(customerDTO.getFirstName());
        }
        if (customerDTO.getLastName() != null) {
            dbCustomer.setLastName(customerDTO.getLastName());
        }
        if (customerDTO.getContact() != null) {
            dbCustomer.setContact(customerDTO.getContact());
        }
        if (customerDTO.getDni() != null) {
            dbCustomer.setDni(customerDTO.getDni());
        }

        return  customerMapper.toDTO(customerRepo.save(dbCustomer));
    }
}
