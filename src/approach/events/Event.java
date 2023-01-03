package approach.events;

import approach.CurrentPage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.ActionInput;
import fileio.Input;

/**
 * Interface for an event
 */
public interface Event {

    /**
     * Method for make an event
     * @param currentPage the current page I'm on
     * @param actionInput action information
     * @param input information about users, movies, actions
     * @param output final ArrayNode in which must be added
     */
    void makeEvent(CurrentPage currentPage, ActionInput actionInput, Input input,
                   ArrayNode output);
}
