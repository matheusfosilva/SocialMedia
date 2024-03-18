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
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentDataService contentDataService;
    private final ContentRepository contentRepository;

    public void getContent(Integer contentId){
        Content content = contentDataService.getById(contentId);
    }

    public void deleteContent(Integer contentId){

        Content content = contentDataService.getById(contentId);
        content.setDeletedAt(LocalDateTime.now());
        contentRepository.save(content);

    }
}
