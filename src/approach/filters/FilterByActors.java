package approach.filters;

import fileio.ActionInput;
import fileio.MovieInput;

import java.util.ArrayList;

/**
 * Class for filter depending on actors
 */
public class FilterByActors implements Filter {

    /**
     * Delete the movies that do not contain the actors in the given list
     * @param currentMovieList movies list for the current user
     * @param actionInput information about actions
     */
    @Override
    public void filter(final ArrayList<MovieInput> currentMovieList,
                       final ActionInput actionInput) {

        for (int i = 0; i < currentMovieList.size(); i++) {
            MovieInput movie = currentMovieList.get(i);
            ArrayList<String> actorsMovie = movie.getActors();
            ArrayList<String> actorsNeeded = actionInput.getFilters().getContains().getActors();

            for (String actor : actorsNeeded) {
                if (!actorsMovie.contains(actor)) {
                    currentMovieList.remove(movie);
                    i--;
                    break;
                }
            }
        }
    }
}
