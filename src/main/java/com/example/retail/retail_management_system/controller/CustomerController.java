package com.example.retail.retail_management_system.controller;

import com.example.retail.retail_management_system.dto.response.ApiResponse;
import com.example.retail.retail_management_system.dto.CustomerDTO;
import com.example.retail.retail_management_system.service.customer.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping("/create")
    public ResponseEntity<Object> createCustomer( @Valid @RequestBody CustomerDTO customerDTO){
        CustomerDTO dbCustomerDTO = customerService.createCustomer(customerDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Customer created successfully", dbCustomerDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllCustomers(){
        List<CustomerDTO> customers = customerService.getCustomers();

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("Customer list", customers));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomer( @PathVariable Long id){
        CustomerDTO customerDTO = customerService.getCustomer(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("Customer found successfully", customerDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);

        return ResponseEntity.ok("Customer deleted successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCustomer(@Valid @RequestBody CustomerDTO customerDTO, @PathVariable Long id){
        CustomerDTO dbCustomerDTO = customerService.updateCustomer(id, customerDTO);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("Updated Customer successfully", dbCustomerDTO));
    }



}
