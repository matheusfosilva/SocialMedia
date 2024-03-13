package com.portfolioapi.PortfolioApi.dto.users;

import com.portfolioapi.PortfolioApi.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserResponse {

    private Integer id;
    private String fullName;
    private String email;

    public RegisterUserResponse(User user) {
        this.id = user.getId();
        this.fullName = user.getFullName();
        this.email = user.getEmail();
    }
}
