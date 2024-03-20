package com.portfolioapi.PortfolioApi.services.data;

import com.portfolioapi.PortfolioApi.model.forum.Content;
import com.portfolioapi.PortfolioApi.repositories.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentDataService extends AbstractDataService<Content, Integer, ContentRepository>{

    private final ContentRepository contentRepository;

    public void deleteContentById(Integer contentId) {
        Content content = getById(contentId);
        content.setDeletedAt(LocalDateTime.now());
        contentRepository.save(content);
    }

    public List<Content> getAllValidPosts(){
        return contentRepository.findAllByDeletedAtIsNull();
    }
}
