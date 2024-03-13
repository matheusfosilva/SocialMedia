package com.portfolioapi.PortfolioApi.model.forum;

import com.portfolioapi.PortfolioApi.model.BaseModel;
import com.portfolioapi.PortfolioApi.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public abstract class Content extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    @ManyToOne
    private User author;

}
