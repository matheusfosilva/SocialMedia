package com.portfolioapi.PortfolioApi.model;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseModel implements Serializable {

    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    @PrePersist
    private void preCreate(){
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate(){
        this.updatedAt = LocalDateTime.now();
    }

}
