package com.portfolioapi.PortfolioApi.services.data;

import com.portfolioapi.PortfolioApi.exceptions.ResourceNotFoundException;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class AbstractDataService<T, ID, R extends JpaRepository<T, ID>> {

    private R repository;

    @Autowired
    public void setRepository(R repository) {
        this.repository = repository;
    }

    public T getById(ID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
    }

}
