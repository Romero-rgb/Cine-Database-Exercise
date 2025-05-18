package dev.antonio.cine.model;

import dev.antonio.cine.util.BoxOfficeCalculable;
import dev.antonio.cine.util.Constants;

public abstract class Movie implements BoxOfficeCalculable {
    private String name;
    private double cost;
    private int crew = 1;

    public Movie(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    public Movie(String name, double cost, int crew) {
        this.setName(name);
        this.setCost(cost);
        this.setCrew(crew);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(Constants.MOVIE_NOT_EXISTS_OR_NULL);
        } else {
            this.name = name;
        }

    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (cost <= 0) {
            throw new IllegalArgumentException(Constants.NEGATIVE_COST);
        } else {
            this.cost = cost;
        }
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        if (crew < 1) {
            throw new IllegalArgumentException(Constants.CREW_NEGATIVE);
        } else {
            this.crew = crew;
        }
    }

    public void decrementtCrew(){
        if (!thereIsCrew()) {
            throw new IllegalArgumentException(Constants.CREW_NEGATIVE);
        } else {
            --crew;
        }
    }

    public void decrementtCrew(int quantity){
         if (!thereIsCrew()) {
            throw new IllegalArgumentException(Constants.CREW_NEGATIVE);
        } else {
            crew -= quantity;
        }
    }

    public boolean thereIsCrew(){
        if (crew >= 1) {
            return true;
        } else {
            return false;
        }
    }

    protected String movieToString(){
        return name + "," + cost + "," + crew;
    }

    public String toString() {
        return movieToString() + "\n";
    }
    
}
