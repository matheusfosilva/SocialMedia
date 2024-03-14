package com.portfolioapi.PortfolioApi.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public abstract class SoftDelete extends BaseModel {

    protected LocalDateTime deletedAt;
}
