package approach.events;

import displays.DisplayCommand;
import displays.ErrorDisplay;
import approach.CurrentPage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.ActionInput;
import fileio.Input;

/**
 * Class for the filter action
 */
public class FilterEvent implements Event {

    /**
     * Filter the current movies list by the filter details (sort and contains)
     * @param currentPage the current page I'm on
     * @param actionInput action information
     * @param input information about users, movies, actions
     * @param output final ArrayNode in which must be added
     */
    @Override
    public void makeEvent(final CurrentPage currentPage, final ActionInput actionInput,
                          final Input input, final ArrayNode output) {

        if (currentPage.getPageName().compareTo("movies") == 0) {

            currentPage.clearCurrentMoviesList();
            currentPage.populateCurrentMoviesList(input);
            currentPage.filterMoviesList(actionInput);
            DisplayCommand.writeInOutput(output, currentPage);

        } else {
            ErrorDisplay.displayError(output);
        }
    }
}
