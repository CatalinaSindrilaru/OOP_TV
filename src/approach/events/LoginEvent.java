package approach.events;

import displays.DisplayCommand;
import displays.ErrorDisplay;
import approach.CurrentPage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.ActionInput;
import fileio.Input;

/**
 * Class for the login action
 */
public class LoginEvent implements Event {

    /**
     * Login the user with the given credentials
     * @param currentPage the current page I'm on
     * @param actionInput action information
     * @param input information about users, movies, actions
     * @param output final ArrayNode in which must be added
     */
    @Override
    public void makeEvent(final CurrentPage currentPage, final ActionInput actionInput,
                          final Input input, final ArrayNode output) {

        if (currentPage.getPageName().compareTo("login") == 0) {

            if (input.findUser(actionInput.getCredentials()) != null) {

                currentPage.setCurrentUser(input.findUser(actionInput.getCredentials()));
                currentPage.setPageName("Homepage autentificat");
                currentPage.clearCurrentMoviesList();
                DisplayCommand.writeInOutput(output, currentPage);
                currentPage.getOldPages().push(new CurrentPage(currentPage));;

            } else {
                /* If the user doesn't exist in the database */
                currentPage.setPageName("Homepage neautentificat");
                currentPage.getOldPages().push(new CurrentPage(currentPage));
                ErrorDisplay.displayError(output);
            }
        } else {
            ErrorDisplay.displayError(output);
        }
    }
}
