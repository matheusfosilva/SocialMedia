package com.portfolioapi.PortfolioApi.services.data;

import com.portfolioapi.PortfolioApi.model.user.User;
import com.portfolioapi.PortfolioApi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataService extends AbstractDataService<User, Integer, UserRepository>{

    public UserDataService(UserRepository repository) {
        super(repository);
    }

}
