package com.portfolioapi.PortfolioApi.dto.forum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PublishPostRequest {

    private String title;
    private String description;
    private Integer authorId;
    private List<String> files;
}
