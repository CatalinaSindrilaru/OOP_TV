package approach.filters;

import fileio.FiltersSort;
import fileio.MovieInput;

import java.util.ArrayList;

public final class Sort {

    private Sort() { }

    /**
     * Sort the list of movies by the criteria from the sort parameter
     * @param movies list of movies that need to be sort
     * @param sort criteria for sort
     */
    public static void sortMovies(final ArrayList<MovieInput> movies, final FiltersSort sort) {

        String rating = sort.getRating();
        String duration = sort.getDuration();

        movies.sort((o1, o2) -> {

            if (duration != null && rating != null) {
                if (duration.compareTo("increasing") == 0) {
                    return compareDuration(o1, o2, o1.getDuration(), o2.getDuration(), rating);
                } else {

                    return compareDuration(o1, o2, o2.getDuration(), o1.getDuration(), rating);
                }

            } else if (duration != null) {
                if (duration.compareTo("increasing") == 0) {
                    return Integer.compare(o1.getDuration(), o2.getDuration());
                } else {
                    return Integer.compare(o2.getDuration(), o1.getDuration());
                }

            } else {
                if (rating.compareTo("increasing") == 0) {
                    return Float.compare(o1.getRating(), o2.getRating());
                } else {
                    return Float.compare(o2.getRating(), o1.getRating());
                }
            }
        });
    }

    /**
     *
     * @param o1 first movie
     * @param o2 second movie
     * @param duration duration for first movie
     * @param duration2 duration for second movie
     * @param rating increasing/decreasing
     * @return number according to which the sorting will be done
     */
    private static int compareDuration(final MovieInput o1, final MovieInput o2,
                                       final int duration, final int duration2,
                                       final String rating) {

        if (o1.getDuration() != o2.getDuration()) {
            return Integer.compare(duration, duration2);
        } else {

            if (rating.compareTo("increasing") == 0) {
                return Float.compare(o1.getRating(), o2.getRating());
            } else {
                return Float.compare(o2.getRating(), o1.getRating());
            }
        }
    }
}
