package com.portfolioapi.PortfolioApi.model.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(UserFollowId.class)
public class UserFollow {

    @Id
    @ManyToOne
    private User following;

    @Id
    @ManyToOne
    private User followed;
}
