package com.portfolioapi.PortfolioApi.repositories;

import com.portfolioapi.PortfolioApi.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAllByDeletedAtIsNull();
}
