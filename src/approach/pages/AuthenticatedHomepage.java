package approach.pages;

import displays.ErrorDisplay;
import approach.CurrentPage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.ActionInput;

/**
 * Verify errors for "Homepage Autentificat"
 */
public class AuthenticatedHomepage implements Errors {

    /**
     * Verify if the action is places on the right page
     * @param currentPage the current page I'm on
     * @param actionInput action information
     * @param output final ArrayNode in which must be added
     * @return true/false
     */
    @Override
    public boolean checkErrors(final CurrentPage currentPage, final ActionInput actionInput,
                               final ArrayNode output) {
        if (actionInput.getPage().compareTo("movies") != 0
                && actionInput.getPage().compareTo("upgrades") != 0
                && actionInput.getPage().compareTo("logout") != 0) {

            ErrorDisplay.displayError(output);
            return true;
        }
        return false;
    }
}
