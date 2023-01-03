package approach.events;

import displays.DisplayCommand;
import displays.ErrorDisplay;
import approach.CurrentPage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.ActionInput;
import fileio.Input;
import fileio.MovieInput;
import fileio.UserInput;

/**
 * Class for the purchase action
 */
public class PurchaseEvent implements Event {

    /**
     * Purchase the movie, decrease the tokens and add it to the purchased movies list
     * of the current user
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
            UserInput currentUser = currentPage.getCurrentUser();

            if (currentUser.getPurchasedMovies().contains(movie)) {
                ErrorDisplay.displayError(output);
                return;
            }
            /* Verify if the current user has premium account */
            if (currentUser.getCredentials().getAccountType().compareTo("premium") == 0) {

                /* Verify if it still has free movies */
                if (currentUser.getNumFreePremiumMovies() >= 1) {
                    int freeMovies = currentUser.getNumFreePremiumMovies();
                    currentUser.setNumFreePremiumMovies(freeMovies - 1);
                } else {
                    int tokens = currentUser.getTokensCount();
                    currentUser.setTokensCount(tokens - 2);
                }

            } else {
                int tokens = currentUser.getTokensCount();
                currentUser.setTokensCount(tokens - 2);
            }

            currentUser.addAtPurchasedMovies(movie);
            DisplayCommand.writeInOutput(output, currentPage);

        } else {
            ErrorDisplay.displayError(output);
        }
    }
}
