package com.portfolioapi.PortfolioApi.model;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.io.Serializable;
import java.time.LocalDateTime;


public abstract class BaseModel implements Serializable {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    private void preCreate(){
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate(){
        this.updatedAt = LocalDateTime.now();
    }

}
