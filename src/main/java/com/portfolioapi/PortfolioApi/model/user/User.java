package com.portfolioapi.PortfolioApi.model.user;

import com.portfolioapi.PortfolioApi.dto.users.RegisterUserRequest;
import com.portfolioapi.PortfolioApi.dto.users.UpdateUserRequest;
import com.portfolioapi.PortfolioApi.model.BaseModel;
import com.portfolioapi.PortfolioApi.model.SoftDelete;
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
public class User extends SoftDelete {

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

    public void updateUser (UpdateUserRequest updateUserRequest){
        this.name = updateUserRequest.getName();
        this.lastname = updateUserRequest.getLastname();
        this.bornDate = updateUserRequest.getBornDate();
        this.phone = updateUserRequest.getPhone();
    }
}
