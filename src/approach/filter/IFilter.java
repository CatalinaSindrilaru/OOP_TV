package approach.filter;

import fileio.FiltersContains;
import fileio.MovieInput;
import java.util.ArrayList;

public interface IFilter {

    /**
     * Apply filter to the given list and return the result
     * @param movies list that I want to filter
     * @param contains the criteria according to which the filtering is done
     * @return filtered list
     */
    ArrayList<MovieInput> meetCriteria(ArrayList<MovieInput> movies,
                                       FiltersContains contains);
}
