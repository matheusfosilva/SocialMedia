package com.portfolioapi.PortfolioApi.services;


import com.portfolioapi.PortfolioApi.exceptions.ResourceNotFoundException;
import com.portfolioapi.PortfolioApi.model.forum.Content;
import com.portfolioapi.PortfolioApi.model.user.User;
import com.portfolioapi.PortfolioApi.repositories.ContentRepository;
import com.portfolioapi.PortfolioApi.services.data.ContentDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentDataService contentDataService;

    public void get(Integer contentId){

        Content content = contentDataService.getById(contentId);

    }

}
