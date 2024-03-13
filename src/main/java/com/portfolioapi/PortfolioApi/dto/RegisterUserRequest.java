package com.portfolioapi.PortfolioApi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class RegisterUserRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotNull
    private LocalDate bornDate;
    @NotBlank
    private String email;
    @NotBlank
    private String phone;

}
