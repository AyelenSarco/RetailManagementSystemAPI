package com.example.retail.retail_management_system.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate saleDate;
    private Double total;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL,
                orphanRemoval = true, fetch = FetchType.EAGER)
    private List<SaleDetail> saleDetails = new ArrayList<>();

    @ManyToOne
    private Customer customer;


}
