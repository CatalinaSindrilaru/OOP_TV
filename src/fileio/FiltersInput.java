package fileio;

/**
 * Class that contains the information about the sort
 * and the contains fields for filter the list of movies
 */
public class FiltersInput {
    private FiltersSort sort;
    private FiltersContains contains;

    public FiltersInput() {

    }

    public FiltersInput(final FiltersSort sort, final FiltersContains contains) {
        this.sort = sort;
        this.contains = contains;
    }

    /**
     * @return sort
     */
    public FiltersSort getSort() {
        return sort;
    }

    /**
     * @param sort new value
     */
    public void setSort(final FiltersSort sort) {
        this.sort = sort;
    }

    /**
     * @return contains
     */
    public FiltersContains getContains() {
        return contains;
    }

    /**
     * @param contains new value
     */
    public void setContains(final FiltersContains contains) {
        this.contains = contains;
    }
}
