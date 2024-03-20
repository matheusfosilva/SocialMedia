package com.portfolioapi.PortfolioApi.model.forum;

import com.portfolioapi.PortfolioApi.model.forum.Content;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Coment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostComment extends Content {

    private Content parent;
}
