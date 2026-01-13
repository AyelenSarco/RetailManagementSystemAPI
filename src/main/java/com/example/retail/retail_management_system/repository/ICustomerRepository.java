package com.example.retail.retail_management_system.repository;

import com.example.retail.retail_management_system.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {

}
