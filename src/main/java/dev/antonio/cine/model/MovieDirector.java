/**
 * Represents a commercial movie with a director and a release date.
 * Extends the {@link Movie} class by adding director and release date information.
 * Provides methods to calculate box office revenue, validate release dates, and update release dates.
 * <p>
 * The release date must be in the format specified by {@link dev.antonio.cine.util.Constants#DATE_FORMAT}
 * and cannot be in the past.
 * </p>
 *
 * @author Antonio
 */
package dev.antonio.cine.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import dev.antonio.cine.util.Constants;

public class MovieDirector extends Movie {
    private String director;
    private LocalDate releaseDate;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);

    public MovieDirector(String name, double cost, int crew, String director, String releaseDate) {
        super(name, cost, crew);

        this.director = director;

        validateReleaseDate(releaseDate);
        this.releaseDate = LocalDate.parse(releaseDate, DATE_FORMATTER);
    }

    public MovieDirector(String name, double cost, String director, String releaseDate) {
        super(name, cost);

        this.director = director;

        validateReleaseDate(releaseDate);
        this.releaseDate = LocalDate.parse(releaseDate, DATE_FORMATTER);
    }

    public double calculateBox(double tickets) {

        if (tickets < 0) {
            throw new IllegalArgumentException(Constants.NEGATIVE_TICKETS);
        } else if (isCloseToRelease()) {
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReleaseDate() {
        return releaseDate.format(DATE_FORMATTER);
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = LocalDate.parse(releaseDate, DATE_FORMATTER);
    }

    @Override
    protected String movieToString() {
        return super.movieToString() + "," + Constants.TYPE_COMMERCIAL + "," + getDirector() + "," + getReleaseDate();
    }


}
