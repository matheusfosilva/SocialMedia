package com.portfolioapi.PortfolioApi.repositories;

import com.portfolioapi.PortfolioApi.model.forum.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Integer> {
}
