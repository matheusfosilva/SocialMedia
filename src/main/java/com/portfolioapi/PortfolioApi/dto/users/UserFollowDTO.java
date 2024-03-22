package com.portfolioapi.PortfolioApi.dto.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserFollowDTO {

    private Integer followingId;
    private Integer followedId;
}
