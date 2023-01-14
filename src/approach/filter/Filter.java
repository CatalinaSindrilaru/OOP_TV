package approach.filter;

import approach.CurrentPage;
import fileio.FiltersContains;
import fileio.MovieInput;
import java.util.ArrayList;

public final class Filter {

    private Filter() {
    }

    public static void filterContains(final CurrentPage currentPage,
                                      final FiltersContains contains) {

            IFilter actorsFilter = new CriteriaActors();
            IFilter genresFilter = new CriteriaGenre();
            IFilter andFilter = new AndCriteria(actorsFilter, genresFilter);

            ArrayList<MovieInput> newMoviesList;

            if (contains.getActors() != null && contains.getGenre() != null) {
                newMoviesList = andFilter.meetCriteria(currentPage.getCurrentMovieList(),
                        contains);

            } else if (contains.getActors() != null) {
                newMoviesList = actorsFilter.meetCriteria(currentPage.getCurrentMovieList(),
                        contains);

            } else {
                newMoviesList = genresFilter.meetCriteria(currentPage.getCurrentMovieList(),
                        contains);
            }

            currentPage.setCurrentMovieList(newMoviesList);
    }
}
