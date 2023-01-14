package approach.actionPage.mainActions;

import approach.CurrentPage;
import approach.actionPage.ActionPage;
import approach.events.Event;
import approach.events.EventsFactory;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.ActionInput;
import fileio.Input;

/**
 * Class for "on page" action
 */
public class OnPage implements ActionPage {

    /**
     * Call methods for each type of action ("on page")
     *
     * @param currentPage the current page I'm on
     * @param actionInput action information
     * @param input       information about users, movies, actions
     * @param output      final ArrayNode in which must be added
     * @return current page
     */
    @Override
    public CurrentPage resolveCommand(final CurrentPage currentPage, final ActionInput actionInput,
                                      final Input input, final ArrayNode output) {

        EventsFactory eventsFactory = new EventsFactory();
        Event event = null;

        if (actionInput.getFeature().compareTo("register") == 0) {
            event = eventsFactory.createEvent("register");

        } else if (actionInput.getFeature().compareTo("login") == 0) {
            event = eventsFactory.createEvent("login");

        } else if (actionInput.getFeature().compareTo("filter") == 0) {
            event = eventsFactory.createEvent("filter");

        } else if (actionInput.getFeature().compareTo("search") == 0) {
            event = eventsFactory.createEvent("search");

        } else if (actionInput.getFeature().compareTo("buy tokens") == 0) {
            event = eventsFactory.createEvent("buy tokens");

        } else if (actionInput.getFeature().compareTo("buy premium account") == 0) {
            event = eventsFactory.createEvent("buy premium account");

        } else if (actionInput.getFeature().compareTo("purchase") == 0) {
            event = eventsFactory.createEvent("purchase");

        } else if (actionInput.getFeature().compareTo("watch") == 0) {
            event = eventsFactory.createEvent("watch");

        } else if (actionInput.getFeature().compareTo("like") == 0) {
            event = eventsFactory.createEvent("like");

        } else if (actionInput.getFeature().compareTo("rate") == 0) {
            event = eventsFactory.createEvent("rate");

        } else if (actionInput.getFeature().compareTo("subscribe") == 0) {
            event = eventsFactory.createEvent("subscribe");
        }

        assert event != null;
        event.makeEvent(currentPage, actionInput, input, output);
        return currentPage;
    }
}
