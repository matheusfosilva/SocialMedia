package com.portfolioapi.PortfolioApi.utils;

import com.portfolioapi.PortfolioApi.model.user.User;
import com.portfolioapi.PortfolioApi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;

@Service
@RequiredArgsConstructor
public class CreateUserUtils {

    private final UserRepository userRepository;

    public  User createUserForTest(){
        User user = User.builder()
                .name("user")
                .lastname("lastname")
                .email("user@mail.com")
                .phone("784512963")
                .bornDate(LocalDate.of(1999, Month.NOVEMBER, 27))
                .build();

        return userRepository.save(user);
    }

}
