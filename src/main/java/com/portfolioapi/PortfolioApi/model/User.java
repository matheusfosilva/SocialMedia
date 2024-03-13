package com.portfolioapi.PortfolioApi.model;

import com.portfolioapi.PortfolioApi.dto.RegisterUserRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

@Entity(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastname;
    private LocalDate bornDate;
    private String email;
    private String phone;

    public User(RegisterUserRequest userRequest) {
        this.name = userRequest.getName();
        this.lastname = userRequest.getLastname();
        this.bornDate = userRequest.getBornDate();
        this.email = userRequest.getEmail();
        this.phone = userRequest.getPhone();
    }

    public String getFullName() {
        return StringUtils.capitalize(this.name + " " + this.lastname);
    }
}
