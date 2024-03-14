package com.portfolioapi.PortfolioApi.services.data;

import com.portfolioapi.PortfolioApi.model.user.User;
import com.portfolioapi.PortfolioApi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDataService extends AbstractDataService<User, Integer, UserRepository> {


    private final UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAllByDeletedAtIsNull();
    }


}
