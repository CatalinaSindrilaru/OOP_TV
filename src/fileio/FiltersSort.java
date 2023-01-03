package fileio;

/**
 * Class that contains the rating and the duration
 * according to which the list of movies must be sorted
 */
public class FiltersSort {
    private String rating;
    private String duration;

    public FiltersSort() {

    }

    public FiltersSort(final String rating, final String duration) {
        this.rating = rating;
        this.duration = duration;
    }

    /**
     * @return rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * @param rating new value
     */
    public void setRating(final String rating) {
        this.rating = rating;
    }

    /**
     * @return duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration new value
     */
    public void setDuration(final String duration) {
        this.duration = duration;
    }
}
