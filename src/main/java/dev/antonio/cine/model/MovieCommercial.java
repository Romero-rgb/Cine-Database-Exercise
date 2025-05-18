package dev.antonio.cine.model;

import dev.antonio.cine.util.Constants;

public class MovieCommercial extends Movie {
    private String brand;

    public MovieCommercial(String name, double cost, int crew, String brand) {
        super(name, cost, crew);

        this.brand = brand;
    }

    
    public MovieCommercial(String name, double cost, String brand) {
        super(name, cost);

        this.brand = brand;
    }

    public double calculateBox(double tickets){
     
        if (tickets < 0) {
            throw new IllegalArgumentException(Constants.NEGATIVE_TICKETS);
        } else {
            return this.movie.getName() - (Constants.TICKET_PRICE * tickets);
        }
    }

    
}
