package approach.filters;

/**
 * Class that implements Factory Design Pattern for filters
 */
public class FiltersFactory {

    /**
     *
     * @param type type of the filter
     * @return object that implements interface Filter
     */
    public Filter createFilter(final String type) {

        if (type.compareTo("actors") == 0) {
            return new FilterByActors();
        } else {
            return new FilterByGenres();
        }

    }
}
