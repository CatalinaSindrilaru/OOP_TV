package approach.events;

import displays.DisplayCommand;
import displays.ErrorDisplay;
import approach.CurrentPage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.ActionInput;
import fileio.Input;
import fileio.MovieInput;

/**
 * Class for the like action
 */
public class LikeEvent implements Event {

    /**
     * Increase the number of likes for a movie and add that movie at
     * the liked movies list of the current user
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

            /* Verify if the movie was visualized */
            if (currentPage.getCurrentUser() != null
                    && currentPage.getCurrentUser().watchedMovie(movie)) {

                if (currentPage.getCurrentUser().getLikedMovies().contains(movie)) {
                    return;
                }
                int numLikes = movie.getNumLikes();
                movie.setNumLikes(numLikes + 1);
                currentPage.getCurrentUser().addAtLikedMovies(movie);
                DisplayCommand.writeInOutput(output, currentPage);

            } else {
                ErrorDisplay.displayError(output);
            }
        } else {
            ErrorDisplay.displayError(output);
        }
    }
}
