package approach.filters;

import fileio.ActionInput;
import fileio.MovieInput;

import java.util.ArrayList;

/**
 * Class for filter depending on genres
 */
public class FilterByGenres implements Filter {

    /**
     * Delete the movies that do not contain the genres in the given list
     * @param currentMovieList movies list for the current user
     * @param actionInput information about actions
     */
    @Override
    public void filter(final ArrayList<MovieInput> currentMovieList,
                       final ActionInput actionInput) {

        for (int i = 0; i < currentMovieList.size(); i++) {
            MovieInput movie = currentMovieList.get(i);
            ArrayList<String> genresMovie = movie.getGenres();
            ArrayList<String> genresNeeded = actionInput.getFilters().getContains().getGenre();

            for (String genre : genresNeeded) {
                if (!genresMovie.contains(genre)) {
                    currentMovieList.remove(movie);
                    i--;
                    break;
                }
            }
        }
    }
}
