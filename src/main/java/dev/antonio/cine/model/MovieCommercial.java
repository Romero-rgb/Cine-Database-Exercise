/**
 * Represents a commercial movie, which is a type of {@link Movie} associated with a specific brand and release date.
 * This class provides additional functionality for handling commercial movies, such as calculating box office revenue
 * with special pricing rules close to the release date, and validating release dates.
 * <p>
 * The release date must be provided in the format specified by {@link Constants#DATE_FORMAT} and cannot be in the past.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 *     MovieCommercial commercial = new MovieCommercial("Ad Movie", 10000.0, 20, "BrandX", "2024-12-01");
 *     double boxOffice = commercial.calculateBox(500);
 * </pre>
 * </p>
 *
 * @author Antonio
 */

package dev.antonio.cine.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import dev.antonio.cine.util.Constants;

public class MovieCommercial extends Movie {
    private String brand;
    private LocalDate releaseDate;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);

    public MovieCommercial(String name, double cost, int crew, String brand, String releaseDate) {
        super(name, cost, crew);

        this.brand = brand;

        validateReleaseDate(releaseDate);

        this.releaseDate = LocalDate.parse(releaseDate, DATE_FORMATTER);
    }

    
    public MovieCommercial(String name, double cost, String brand) {
        super(name, cost);

        this.brand = brand;
    }

    public double calculateBox(double tickets){
     
        if (tickets < 0) {
            throw new IllegalArgumentException(Constants.NEGATIVE_TICKETS);
        } else if ( isCloseToRelease()) {
            return ((Constants.TICKET_PRICE - (Constants.TICKET_PRICE / 100 * 10)) * tickets) - getCost();
        } else {
            return (Constants.TICKET_PRICE * tickets) - getCost();
        }
    }

    private LocalDate validateReleaseDate(String dateString) {
        if (dateString == null || dateString.isEmpty()) {
            throw new IllegalArgumentException(Constants.ERROR_EXPIRATION_DATE_NULL_OR_EMPTY);
        }
        try {
            LocalDate date = LocalDate.parse(dateString, DATE_FORMATTER);

            if (date.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException(Constants.ERROR_EXPIRATION_DATE_PAST);
            }
            return date;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(Constants.ERROR_EXPIRATION_DATE_FORMAT);
        }
    }

    public String getReleaseDate(){
        return releaseDate.format(DATE_FORMATTER);
    }


    public String getBrand() {
        return brand;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }



    public void setReleaseDate(String releaseDate) {
        this.releaseDate = LocalDate.parse(releaseDate, DATE_FORMATTER);
    }

    private boolean isCloseToRelease() {
        LocalDate closeRelease = LocalDate.now().plusDays(Constants.DAYS_CLOSE_TO_RELEASE);
        if (releaseDate.isAfter(closeRelease)) {
            return false;
        } else {
            return true;
        }
    }

    public void updateReleaseDate(String newDate) {
        validateReleaseDate(newDate);
       setReleaseDate(newDate);
    }

    @Override
    protected String movieToString() {
        return super.movieToString() + "," + Constants.TYPE_COMMERCIAL + "," + getBrand() + "," + getReleaseDate();
    }

    
}
