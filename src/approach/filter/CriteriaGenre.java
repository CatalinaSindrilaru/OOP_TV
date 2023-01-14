package approach.filter;

import fileio.FiltersContains;
import fileio.MovieInput;

import java.util.ArrayList;

public class CriteriaGenre implements IFilter {

    /**
     * Apply filter to the given list and return the result
     * @param movies list that I want to filter
     * @param contains the criteria according to which the filtering is done
     * @return filtered list
     */
    @Override
    public ArrayList<MovieInput> meetCriteria(final ArrayList<MovieInput> movies,
                                              final FiltersContains contains) {

        ArrayList<MovieInput> movieListByGenres = new ArrayList<>();

        for (MovieInput movie : movies) {
            ArrayList<String> genresMovie = movie.getGenres();
            ArrayList<String> genres = contains.getGenre();

            for (String genre : genres) {
                if (genresMovie.contains(genre)) {
                    movieListByGenres.add(movie);
                    break;
                }
            }
        }

        return movieListByGenres;
    }
}
