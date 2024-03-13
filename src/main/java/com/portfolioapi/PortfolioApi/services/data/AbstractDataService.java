package com.portfolioapi.PortfolioApi.services.data;

import com.portfolioapi.PortfolioApi.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

@RequiredArgsConstructor
public abstract class AbstractDataService<T, ID, Repository extends JpaRepository<T, ID>> {

    private final Repository repository;

    public T getById(ID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
    }

}
