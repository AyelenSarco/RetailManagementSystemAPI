package com.example.retail.retail_management_system.repository;

import com.example.retail.retail_management_system.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleRepository extends JpaRepository<Sale,Long> {
}
