package com.portfolioapi.PortfolioApi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
