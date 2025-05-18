package dev.antonio.cine.model;

import java.util.*;
import dev.antonio.cine.util.*;

/**
 * Represents a film studio with geographic coordinates and movies inventory
 * management.
 * <p>
 * This class manages a collection of movies and provides functionality to add,
 * update,
 * and apply box office calculate to movies. It also tracks the studio's
 * location using geographic coordinates.
 * </p>
 */

public class Studio {
    private String name;
    private String city;
    private double longitude;
    private double latitude;
    private final Map<String, Movie> movies;

    public Studio(String name, String city, double longitude, double latitude) {
        this.setName(name);
        this.setCity(city);
        this.longitude = longitude;
        this.latitude = latitude;
        this.movies = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(Constants.ERROR_STRING_NULL);
        } else {
            this.name = name;
        }
        
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
         if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException(Constants.ERROR_STRING_NULL);
        } else {
            this.city = city;
        }
        
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public ArrayList<Movie> getMovies() {
        return new ArrayList<>(List.copyOf(this.movies.values()));
    }

    public boolean hasMovie(String movieName){
        return this.movies.containsKey(movieName);
    }

    public void addMovie(Movie movie) {
        if (hasMovie(movie.getName()) || movie == null) {
            throw new IllegalArgumentException(Constants.MOVIE_EXISTS_OR_NULL);
        } else {
            movies.put(movie.getName(), movie);
        }
    }

    public Movie getMovie(String movieName) {
        if (movieName == null || movieName.isEmpty()) {
            throw new IllegalArgumentException(Constants.MOVIE_NOT_EXISTS_OR_NULL);
        } else {
            return movies.get(movieName);
        }
    }

    public void updateMovie(Movie movie){
        if (!hasMovie(movie.getName()) || movie == null) {
            throw new IllegalArgumentException(Constants.MOVIE_NOT_EXISTS_OR_NULL);
        } else {
            movies.replace(movie.getName(), movie);
        }
    }

    public String studioToString() {
        return String.format(Constants.STUDIO_FORMAT, name, city, longitude, latitude) + Constants.LINE_BREAK;
    }

    public String moviesToString() {
        StringBuilder moviesString = new StringBuilder();
        for (Map.Entry<String, Movie> entry : movies.entrySet()) {
            String movieName = entry.getKey();
            Movie movie = entry.getValue();

            moviesString.append(this.name)
            .append(",")
            .append(this.city)
            .append(",")
            .append(movieName)
            .append(",")
            .append(movie.getCost())
            .append(",")
            .append(movie.getCrew());

            if (movie instanceof MovieDirector) {
                MovieDirector director = (MovieDirector) movie;
                moviesString.append(",")
                .append(Constants.TYPE_DIRECTOR)
                .append(",")
                .append(director.getNameDirector());
            } else if (movie instanceof MovieCommercial) {
                MovieCommercial commercial = (MovieCommercial) movie;
                moviesString.append(",")
                .append(Constants.TYPE_COMMERCIAL)
                .append(",")
                .append(commercial.getBrand());
            }

            moviesString.append("\n");
        }
        return moviesString.toString();
    }

    public double BoxOfficeCalculable(String movieName, double tickets) {
        if (movieName == null || movieName.isEmpty()) {
            throw new IllegalArgumentException(Constants.MOVIE_NOT_EXISTS_OR_NULL);
        } else if (!hasMovie(movieName)) {
            throw new IllegalArgumentException(Constants.MOVIE_NOT_EXISTS_OR_NULL);
        } else if (tickets < 0) {
            throw new IllegalArgumentException(Constants.NEGATIVE_TICKETS);
        } else {
            return getMovie(movieName).getCost() - (Constants.TICKET_PRICE * tickets);
        }
    }

}
