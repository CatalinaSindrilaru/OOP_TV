package approach.events;

import approach.CurrentPage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import displays.ErrorDisplay;
import fileio.ActionInput;
import fileio.Input;
import fileio.MovieInput;
import fileio.UserInput;

import java.util.ArrayList;

public class SubscribeEvent implements Event {

    /**
     * Add the wanted genre to the subscribed genres list for the current user
     * @param currentPage the current page I'm on
     * @param actionInput action information
     * @param input information about users, movies, actions
     * @param output final ArrayNode in which must be added
     */
    @Override
    public void makeEvent(final CurrentPage currentPage, final ActionInput actionInput,
                          final Input input, final ArrayNode output) {

        if (currentPage.getPageName().compareTo("see details") == 0) {
            UserInput currentUser = currentPage.getCurrentUser();
            MovieInput currentMovie = currentPage.getCurrentMovieList().get(0);

            ArrayList<String> genresCurrentMovie = currentMovie.getGenres();
            String subscribedGenre = actionInput.getSubscribedGenre();

            if (genresCurrentMovie.contains(subscribedGenre)) {
                if (currentUser.getSubscribedGenres().size() != 0) {
                    if (!currentUser.getSubscribedGenres().contains(subscribedGenre)) {
                        currentUser.addSubscribedGenre(subscribedGenre);
                    } else {
                        ErrorDisplay.displayError(output);
                    }
                } else {
                    currentUser.addSubscribedGenre(subscribedGenre);
                }
            } else {
                ErrorDisplay.displayError(output);
            }
        } else {
            ErrorDisplay.displayError(output);
        }
    }
}
