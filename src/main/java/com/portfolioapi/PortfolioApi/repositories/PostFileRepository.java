package com.portfolioapi.PortfolioApi.repositories;

import com.portfolioapi.PortfolioApi.model.forum.PostFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostFileRepository extends JpaRepository<PostFile, Integer> {
}
