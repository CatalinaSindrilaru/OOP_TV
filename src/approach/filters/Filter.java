package approach.filters;

import fileio.ActionInput;
import fileio.MovieInput;

import java.util.ArrayList;

/**
 * Interface for filter
 */
public interface Filter {
    void filter(ArrayList<MovieInput> currentMovieList, ActionInput actionInput);
}
