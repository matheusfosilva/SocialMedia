package com.portfolioapi.PortfolioApi.services.data;

import com.portfolioapi.PortfolioApi.model.forum.Content;
import com.portfolioapi.PortfolioApi.repositories.ContentRepository;
import org.springframework.stereotype.Service;

@Service
public class ContentDataService extends AbstractDataService<Content, Integer, ContentRepository>{

}
