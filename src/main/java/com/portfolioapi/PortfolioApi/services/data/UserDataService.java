package com.portfolioapi.PortfolioApi.services.data;

import com.portfolioapi.PortfolioApi.model.user.User;
import com.portfolioapi.PortfolioApi.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserDataService extends AbstractDataService<User, Integer, UserRepository> {


    private final UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAllByDeletedAtIsNull();
    }

    public void deleteUser(Integer userId) {
        User user = getById(userId);
        user.setDeletedAt(LocalDateTime.now());
        userRepository.save(user);
    }


}
