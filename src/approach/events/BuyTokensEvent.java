package approach.events;

import displays.ErrorDisplay;
import approach.CurrentPage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.ActionInput;
import fileio.Input;

/**
 * Class for the buy tokens action
 */
public class BuyTokensEvent implements Event {

    /**
     * Current users buy some tokens
     * @param currentPage the current page I'm on
     * @param actionInput action information
     * @param input information about users, movies, actions
     * @param output final ArrayNode in which must be added
     */
    @Override
    public void makeEvent(final CurrentPage currentPage, final ActionInput actionInput,
                          final Input input, final ArrayNode output) {

        if (currentPage.getPageName().compareTo("upgrades") == 0)  {
            BuyFeatures.buyTokens(currentPage, actionInput.getCount());
        } else {
            ErrorDisplay.displayError(output);
        }
    }
}
