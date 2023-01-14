package approach.filter;

import fileio.FiltersContains;
import fileio.MovieInput;

import java.util.ArrayList;

public class CriteriaActors implements IFilter {


    /**
     * Apply filter to the given list and return the result
     * @param movies list that I want to filter
     * @param contains the criteria according to which the filtering is done
     * @return filtered list
     */
    @Override
    public ArrayList<MovieInput> meetCriteria(final ArrayList<MovieInput> movies,
                                              final FiltersContains contains) {

        ArrayList<MovieInput> movieListByActors = new ArrayList<>();

        for (MovieInput movie : movies) {
            ArrayList<String> actorsMovie = movie.getActors();
            ArrayList<String> actors = contains.getActors();

            for (String actor : actors) {
                if (actorsMovie.contains(actor)) {
                    movieListByActors.add(movie);
                    break;
                }
            }
        }

        return movieListByActors;
    }
}
