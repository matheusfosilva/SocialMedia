package com.portfolioapi.PortfolioApi.dto.users;

import com.portfolioapi.PortfolioApi.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;
    private String fullname;
    private LocalDate bornDate;
    private String email;
    private String phone;

    public UserDto(User user) {
        id = user.getId();
        fullname = user.getFullName();
        bornDate = user.getBornDate();
        email = user.getEmail();
        phone = user.getPhone();
    }
}
