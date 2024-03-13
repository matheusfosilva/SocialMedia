package com.portfolioapi.PortfolioApi.model.user;

import com.portfolioapi.PortfolioApi.model.user.User;

import java.io.Serializable;

public class UserFollowId implements Serializable {

    private User following;
    private User followed;
}
