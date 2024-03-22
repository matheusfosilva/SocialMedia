package com.portfolioapi.PortfolioApi.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.portfolioapi.PortfolioApi.dto.users.RegisterUserRequest;
import com.portfolioapi.PortfolioApi.dto.users.RegisterUserResponse;
import com.portfolioapi.PortfolioApi.dto.users.UpdateUserRequest;
import com.portfolioapi.PortfolioApi.dto.users.UserDto;
import com.portfolioapi.PortfolioApi.dto.users.UserFollowDTO;
import com.portfolioapi.PortfolioApi.messaging.NotifyRequestProducer;
import com.portfolioapi.PortfolioApi.model.user.User;
import com.portfolioapi.PortfolioApi.model.user.UserFollow;
import com.portfolioapi.PortfolioApi.repositories.UserRepository;
import com.portfolioapi.PortfolioApi.services.data.UserDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserDataService userDataService;
    private final NotifyRequestProducer notifyRequestProducer;

    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        User user = new User(request);
        return new RegisterUserResponse(userRepository.save(user));
    }

    public UserDto updateUser(Integer userId, UpdateUserRequest updateUserRequest) {

        User user = userDataService.getById(userId);
        user.updateUser(updateUserRequest);
        user = userRepository.save(user);

        return new UserDto(user);

    }

    public UserDto getUser(Integer userId) {
        return new UserDto(userDataService.getById(userId));
    }

    public List<UserDto> getUsers() {
        return userDataService.findAllActiveUsers()
                .stream()
                .map(UserDto::new)
                .toList();
    }

    public void deleteUser(Integer userId) {
        userDataService.deleteUserById(userId);
    }

    public String followUser(UserFollowDTO userFollowDTO) {
        try {
            return notifyRequestProducer.sendMessage(userFollowDTO);
        } catch (JsonProcessingException e) {
            return "notification wasn't sent";
        }
    }

}
