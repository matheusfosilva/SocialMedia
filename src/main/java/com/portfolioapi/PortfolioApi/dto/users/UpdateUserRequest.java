package com.portfolioapi.PortfolioApi.dto.users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotNull
    private LocalDate bornDate;
    @NotBlank
    private String phone;

}
