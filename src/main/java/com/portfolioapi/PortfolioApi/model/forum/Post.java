package com.portfolioapi.PortfolioApi.model.forum;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post extends Content {

    private String title;

    @OneToMany(mappedBy = "post")
    private List<PostFile> files;

}
