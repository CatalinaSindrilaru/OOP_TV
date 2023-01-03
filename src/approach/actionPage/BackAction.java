package approach.actionPage;

import approach.CurrentPage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import displays.DisplayCommand;
import displays.ErrorDisplay;
import fileio.ActionInput;
import fileio.Input;

import java.util.Stack;

public class BackAction implements ActionPage {
    @Override
    public CurrentPage resolveCommand(CurrentPage currentPage, ActionInput actionInput, Input input, ArrayNode output) {

        Stack<CurrentPage> oldPages = currentPage.getOldPages();

        if (oldPages.isEmpty()) {
            ErrorDisplay.displayError(output);

        } else {
            if (currentPage.getCurrentUser() == null) {
                ErrorDisplay.displayError(output);
                return currentPage;
            }

            oldPages.pop();
            if (oldPages.isEmpty()) {
                ErrorDisplay.displayError(output);
                return currentPage;
            }

            String newPage = oldPages.peek().getPageName();

            if (newPage.compareTo("Homepage autentificat") == 0) {
                currentPage = new CurrentPage(oldPages.peek());
                return currentPage;
            }

            if (newPage.compareTo("login") == 0 || newPage.compareTo("register") == 0) {
                ErrorDisplay.displayError(output);
                currentPage = new CurrentPage(oldPages.peek());
                return currentPage;
            }

            if (newPage.compareTo("movies") == 0) {
                currentPage = new CurrentPage(oldPages.peek());
                DisplayCommand.writeInOutput(output, currentPage);
                return currentPage;
            }

            if (newPage.compareTo("see details") == 0) {
                currentPage = new CurrentPage(oldPages.peek());
                DisplayCommand.writeInOutput(output, currentPage);
                return currentPage;
            }

            if (newPage.compareTo("upgrades") == 0) {
                currentPage = new CurrentPage(oldPages.peek());
                return currentPage;
            }
        }

        return currentPage;
    }
}
