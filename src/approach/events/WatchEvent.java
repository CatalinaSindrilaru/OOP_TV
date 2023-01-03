package approach.events;

import displays.DisplayCommand;
import displays.ErrorDisplay;
import approach.CurrentPage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.ActionInput;
import fileio.Input;
import fileio.MovieInput;

/**
 * Class for the watch action
 */
public class WatchEvent implements Event {

    /**
     * Add the movie to the watched list of the user
     * @param currentPage the current page I'm on
     * @param actionInput action information
     * @param input information about users, movies, actions
     * @param output  final ArrayNode in which must be added
     */
    @Override
    public void makeEvent(final CurrentPage currentPage, final ActionInput actionInput,
                          final Input input, final ArrayNode output) {

        if (currentPage.getPageName().compareTo("see details") == 0) {
            // verific daca filmul a fost cumparat mai intai de user
            MovieInput movie = currentPage.getCurrentMovieList().get(0);

            if (currentPage.getCurrentUser() != null
                    && currentPage.getCurrentUser().purchasedMovie(movie)) {

                if (currentPage.getCurrentUser().getWatchedMovies().contains(movie)) {
                    DisplayCommand.writeInOutput(output, currentPage);
                    return;
                }
                currentPage.getCurrentUser().addAtWatchedMovies(movie);
                DisplayCommand.writeInOutput(output, currentPage);

            } else {
                ErrorDisplay.displayError(output);
            }
        } else {
            ErrorDisplay.displayError(output);
        }
    }
}
