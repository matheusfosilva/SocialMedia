package com.portfolioapi.PortfolioApi.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PreRemove;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public abstract class SoftDelete extends BaseModel {

    protected LocalDateTime deletedAt;

}
