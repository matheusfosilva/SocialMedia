package com.portfolioapi.PortfolioApi.controllers;


import com.portfolioapi.PortfolioApi.dto.users.RegisterUserRequest;
import com.portfolioapi.PortfolioApi.dto.users.RegisterUserResponse;
import com.portfolioapi.PortfolioApi.dto.users.UserDto;
import com.portfolioapi.PortfolioApi.dto.users.UserFollowDTO;
import com.portfolioapi.PortfolioApi.services.UserService;
import com.portfolioapi.PortfolioApi.utils.CreateUserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final CreateUserUtils utils;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterUserResponse registerUser(@RequestBody RegisterUserRequest request){
        return userService.registerUser(request);
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getUsers(){
        utils.createUserForTest();
        return userService.getUsers();
    }

    @PostMapping("/follow")
    @ResponseStatus(HttpStatus.OK)
    public String followUser(@RequestBody UserFollowDTO userFollowDTO) {
        return userService.followUser(userFollowDTO);
    }

}
