package com.portfolioapi.PortfolioApi.exceptions;

import java.util.Map;


public class ResourceNotFoundException extends IllegalArgumentException {

    public ResourceNotFoundException() {
        super("Was not found register with informed parameters");
    }

}
