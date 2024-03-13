package com.portfolioapi.PortfolioApi.services;

import com.portfolioapi.PortfolioApi.dto.RegisterUserRequest;
import com.portfolioapi.PortfolioApi.dto.RegisterUserResponse;
import com.portfolioapi.PortfolioApi.model.User;
import com.portfolioapi.PortfolioApi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        User user = new User(request);
        return new RegisterUserResponse(userRepository.save(user));
    }

}
