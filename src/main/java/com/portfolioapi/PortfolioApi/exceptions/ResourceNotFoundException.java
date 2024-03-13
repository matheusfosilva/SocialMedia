package com.portfolioapi.PortfolioApi.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class ResourceNotFoundException extends IllegalArgumentException {


    public ResourceNotFoundException(Class clazz, Map.Entry<String, String> fields) {
        super("Was not found register on %s with parameters %s : %s".formatted(clazz.getName(), fields.getKey(), fields.getValue()));
    }
}
