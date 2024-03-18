package com.portfolioapi.PortfolioApi.repositories;

import com.portfolioapi.PortfolioApi.model.forum.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Integer> {

    List<Content> findAllByDeletedAtIsNull();

}
