package com.portfolioapi.PortfolioApi.repositories;

import com.portfolioapi.PortfolioApi.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
