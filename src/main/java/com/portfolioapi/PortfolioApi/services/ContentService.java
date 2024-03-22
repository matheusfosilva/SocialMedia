package com.portfolioapi.PortfolioApi.services;


import com.portfolioapi.PortfolioApi.dto.forum.PublishPostRequest;
import com.portfolioapi.PortfolioApi.model.forum.Content;
import com.portfolioapi.PortfolioApi.model.forum.Post;
import com.portfolioapi.PortfolioApi.model.forum.PostFile;
import com.portfolioapi.PortfolioApi.model.user.User;
import com.portfolioapi.PortfolioApi.repositories.ContentRepository;
import com.portfolioapi.PortfolioApi.repositories.PostFileRepository;
import com.portfolioapi.PortfolioApi.services.data.ContentDataService;
import com.portfolioapi.PortfolioApi.services.data.UserDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentDataService contentDataService;
    private final UserDataService userDataService;
    private final ContentRepository contentRepository;
    private final PostFileRepository postFileRepository;

    public void publishAPost(PublishPostRequest request) {

        User author = userDataService.getById(request.getAuthorId());

        Post post = new Post() {{
            setTitle(request.getTitle());
            setDescription(request.getDescription());
            setAuthor(author);
        }};

        Post savedPost = contentRepository.save(post);

        registerFilesForPost(request.getFiles(), savedPost);

    }

    public void registerFilesForPost(List<String> files, Post post) {

        List<PostFile> postFiles = files.stream().map(filename ->
                new PostFile() {{
                    setFilename(filename);
                    setPost(post);
                }}
        ).collect(Collectors.toList());

        postFileRepository.saveAll(postFiles);

    }

    public void getContent(Integer contentId) {
        Content content = contentDataService.getById(contentId);
    }


    public void deleteContent(Integer contentId) {
        contentDataService.deleteContentById(contentId);
    }
}
