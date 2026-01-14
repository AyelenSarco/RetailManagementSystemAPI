package com.example.retail.retail_management_system.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {

    private Long id;
    private String firstName;
    private String lastName;


    @NotBlank(message = "Contact is required")
    @Pattern(
            regexp = "^[0-9]+$",
            message = "Contact must contain only numbers"
    )
    @Size(
            min = 8,
            max = 15,
            message = "Contact must be between 8 and 15 digits"
    )
    private String contact;


    @NotBlank(message = "DNI is required")
    @Pattern(
            regexp = "^[0-9]+$",
            message = "DNI must contain only numbers"
    )
    @Size(
            min = 7,
            max = 8,
            message = "DNI must be between 7 and 8 digits"
    )
    private String dni;
}
