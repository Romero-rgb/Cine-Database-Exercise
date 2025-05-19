
/**
 * Represents an imported movie, encapsulating a {@link Movie} object and its country of origin.
 * <p>
 * This class ensures that both the movie and the country of origin are valid and not null.
 * </p>
 *
 * @author Antonio
 */
package dev.antonio.cine.model;

import dev.antonio.cine.util.Constants;

public class ImportedMovie {
    private Movie movie;
    private String countryOfOrigin;

    public ImportedMovie(Movie movie, String countryOfOrigin) {
        this.setMovie(movie);
        this.setCountryOfOrigin(countryOfOrigin);
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        if (movie == null) {
            throw new IllegalArgumentException(Constants.MOVIE_EXISTS_OR_NULL);
        } else {
            this.movie = movie;

        }
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        if (countryOfOrigin == null || countryOfOrigin.isEmpty()) {
            throw new IllegalArgumentException(Constants.COUNTRY_NULL);

        } else {
            this.countryOfOrigin = countryOfOrigin;

        }
    }

    @Override
    public String toString() {
        return movie.movieToString() + "," + countryOfOrigin;
    }

}
