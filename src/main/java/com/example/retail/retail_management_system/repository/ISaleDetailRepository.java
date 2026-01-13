package com.example.retail.retail_management_system.repository;

import com.example.retail.retail_management_system.model.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleDetailRepository extends JpaRepository<SaleDetail,Long> {
}
