package com.example.retail.retail_management_system.dto;


import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {

    private Long customerId;
    private String firstName;
    private String lastName;
    @NotNull
    private String contact;
    @NotNull
    private String dni;
}
