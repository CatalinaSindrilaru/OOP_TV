package approach.filter;

import fileio.FiltersContains;
import fileio.MovieInput;

import java.util.ArrayList;

public class AndCriteria implements IFilter {

    private final IFilter filter1;
    private final IFilter filter2;

    public AndCriteria(final IFilter filter1, final IFilter filter2) {
        this.filter1 = filter1;
        this.filter2 = filter2;
    }

    /**
     * Apply filter to the given list and return the result
     * @param movies list that I want to filter
     * @param contains the criteria according to which the filtering is done
     * @return filtered list
     */
    @Override
    public ArrayList<MovieInput> meetCriteria(final ArrayList<MovieInput> movies,
                                              final FiltersContains contains) {

        ArrayList<MovieInput> firstList;
        firstList = filter1.meetCriteria(movies, contains);

        return filter2.meetCriteria(firstList, contains);
    }
}
