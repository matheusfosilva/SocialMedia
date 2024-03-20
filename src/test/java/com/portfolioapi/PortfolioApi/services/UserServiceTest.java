package com.portfolioapi.PortfolioApi.services;

import com.portfolioapi.PortfolioApi.dto.users.RegisterUserRequest;
import com.portfolioapi.PortfolioApi.repositories.UserRepository;
import com.portfolioapi.PortfolioApi.services.data.UserDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDataService userDataService;
    @Autowired
    private UserRepository userRepository;
    private static final String DEFAULT_EMAIL = "user@mail.com";

    @Test
    void featuresFromUserTest(){

        var request = RegisterUserRequest.builder()
                .name("usuario")
                .lastname("lastname")
                .bornDate(LocalDate.now().minusYears(10))
                .email(DEFAULT_EMAIL)
                .phone("88988185706")
                .build();

        var savedUser = userService.registerUser(request);

        var testingUser = userDataService.getById(savedUser.getId());

        assertThat(testingUser.getName()).isEqualTo(request.getName());
        assertThat(testingUser.getLastname()).isEqualTo(request.getLastname());
        assertThat(testingUser.getBornDate()).isEqualTo(request.getBornDate());
        assertThat(testingUser.getEmail()).isEqualTo(request.getEmail());
        assertThat(testingUser.getPhone()).isEqualTo(request.getPhone());
        assertThat(testingUser.getCreatedAt().toLocalDate()).isEqualTo(LocalDate.now());
        assertThat(testingUser.getUpdatedAt()).isNull();
        assertThat(testingUser.getDeletedAt()).isNull();

        testingUser.setName("updatedName");

        testingUser = userRepository.save(testingUser);

        assertThat(testingUser.getName()).isEqualTo("updatedName");
        assertThat(testingUser.getCreatedAt().toLocalDate()).isEqualTo(LocalDate.now());
        assertThat(testingUser.getUpdatedAt().toLocalDate()).isEqualTo(LocalDate.now());
        assertThat(testingUser.getDeletedAt()).isNull();

        assertThat(userRepository.findAll()).hasSize(1);

        userService.deleteUser(testingUser.getId());

        assertThat(userRepository.findAll()).isEmpty();



    }

}
