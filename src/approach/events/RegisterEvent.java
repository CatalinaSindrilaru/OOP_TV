package approach.events;

import displays.DisplayCommand;
import displays.ErrorDisplay;
import approach.CurrentPage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.ActionInput;
import fileio.Credentials;
import fileio.Input;
import fileio.UserInput;

/**
 * Class for the register action
 */
public class RegisterEvent implements Event {

    /**
     * Add the user with the given credentials to the list of users and
     * make that user the current one
     * @param currentPage the current page I'm on
     * @param actionInput action information
     * @param input information about users, movies, actions
     * @param output final ArrayNode in which must be added
     */
    @Override
    public void makeEvent(final CurrentPage currentPage, final ActionInput actionInput,
                          final Input input, final ArrayNode output) {

        if (currentPage.getPageName().compareTo("register") == 0) {

            Credentials credentials = actionInput.getCredentials();

            UserInput user = new UserInput();
            user.setCredentials(credentials);
            input.addUser(user);

            currentPage.setCurrentUser(user);
            currentPage.setPageName("Homepage autentificat");
            currentPage.clearCurrentMoviesList();
            DisplayCommand.writeInOutput(output, currentPage);
            currentPage.getOldPages().push(new CurrentPage(currentPage));

        } else {
            ErrorDisplay.displayError(output);
        }
    }
}
