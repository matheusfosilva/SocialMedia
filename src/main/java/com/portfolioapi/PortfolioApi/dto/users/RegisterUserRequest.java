package com.portfolioapi.PortfolioApi.dto.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    @Email
    private String email;

    @NotBlank
    private String phone;

}
