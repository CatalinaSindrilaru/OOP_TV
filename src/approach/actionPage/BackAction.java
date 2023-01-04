package approach.actionPage;

import approach.CurrentPage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import displays.DisplayCommand;
import displays.ErrorDisplay;
import fileio.ActionInput;
import fileio.Input;

import java.util.Stack;

public class BackAction implements ActionPage {

    /**
     * Resolve the back command by return to the previous page
     * @param currentPage the current page I'm on
     * @param actionInput action information
     * @param input information about users, movies, actions
     * @param output final ArrayNode in which must be added
     * @return current page
     */
    @Override
    public CurrentPage resolveCommand(CurrentPage currentPage, final ActionInput actionInput,
                                      final Input input, final ArrayNode output) {

        Stack<CurrentPage> oldPages = currentPage.getOldPages();

        if (oldPages.isEmpty()) {
            ErrorDisplay.displayError(output);

        } else {

            if (currentPage.getCurrentUser() == null) {
                ErrorDisplay.displayError(output);
                return currentPage;
            }

            String newPage = oldPages.peek().getPageName();

            if (newPage.compareTo("Homepage autentificat") == 0) {
                currentPage = new CurrentPage(oldPages.peek());
                ErrorDisplay.displayError(output);
                return currentPage;
            }

            oldPages.pop();
            newPage = oldPages.peek().getPageName();
            if (oldPages.isEmpty()) {
                ErrorDisplay.displayError(output);
                return currentPage;
            }

            if (newPage.compareTo("Homepage autentificat") == 0) {
                currentPage = new CurrentPage(oldPages.peek());
                return currentPage;

            } else if (newPage.compareTo("login") == 0 || newPage.compareTo("register") == 0) {
                ErrorDisplay.displayError(output);
                currentPage = new CurrentPage(oldPages.peek());
                return currentPage;

            } else if (newPage.compareTo("movies") == 0) {
                currentPage = new CurrentPage(oldPages.peek());
                DisplayCommand.writeInOutput(output, currentPage);
                return currentPage;

            } else if (newPage.compareTo("see details") == 0) {
                currentPage = new CurrentPage(oldPages.peek());
                DisplayCommand.writeInOutput(output, currentPage);
                return currentPage;

            } else if (newPage.compareTo("upgrades") == 0) {
                currentPage = new CurrentPage(oldPages.peek());
                return currentPage;
            }
        }

        return currentPage;
    }
}
