package approach.events;

import displays.DisplayCommand;
import displays.ErrorDisplay;
import approach.CurrentPage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.ActionInput;
import fileio.Input;
import fileio.MovieInput;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for the rate action
 */
public class RateEvent implements Event {

    public static final int MAX_RATE = 5;
    /**
     * Rate the movie and add it to the rated movies list of the current user
     * @param currentPage the current page I'm on
     * @param actionInput action information
     * @param input information about users, movies, actions
     * @param output final ArrayNode in which must be added
     */
    @Override
    public void makeEvent(final CurrentPage currentPage, final ActionInput actionInput,
                          final Input input, final ArrayNode output) {

        if (currentPage.getPageName().compareTo("see details") == 0) {
            MovieInput movie = currentPage.getCurrentMovieList().get(0);

            /* verify if the movie was visualised first */
            if (currentPage.getCurrentUser() != null
                    && currentPage.getCurrentUser().watchedMovie(movie)) {

//                if (currentPage.getCurrentUser().getRatedMovies().contains(movie)) {
//                    DisplayCommand.writeInOutput(output, currentPage);
//                    return;
//                }
                int rate = actionInput.getRate();
                if (rate > MAX_RATE) {
                    ErrorDisplay.displayError(output);
                    return;
                }

                /* Update the sum and num for rating */
//                int oldSumRatings = movie.getSumRatings();
                HashMap<String, Integer> ratings = movie.getRatings();
                int oldNumRatings = movie.getNumRatings();

//                movie.setSumRatings(oldSumRatings + rate);
                if (!ratings.containsKey(currentPage.getCurrentUser().getCredentials().getName())) {
                    movie.setNumRatings(oldNumRatings + 1);
                    currentPage.getCurrentUser().addAtRatedMovies(movie);
                }

                /* Calculate again */
//                float newRating = (float) movie.getSumRatings() / movie.getNumRatings();
                ratings.put(currentPage.getCurrentUser().getCredentials().getName(), rate);
                // calculate the sum
                int sum = 0;
                for (Map.Entry<String, Integer> entry : ratings.entrySet()) {
                    sum += entry.getValue();
                }
                float newRating = (float)sum / movie.getNumRatings();
                movie.setRating(newRating);

//                currentPage.getCurrentUser().addAtRatedMovies(movie);
                DisplayCommand.writeInOutput(output, currentPage);

            } else {
//                int rate = actionInput.getRate();
//                if (rate > MAX_RATE) {
//                    ErrorDisplay.displayError(output);
////                    return;
//                }
                ErrorDisplay.displayError(output);
            }
        } else {
            int rate = actionInput.getRate();
            if (rate > MAX_RATE) {
                ErrorDisplay.displayError(output);
//                    return;
            }
            ErrorDisplay.displayError(output);
        }
    }
}
