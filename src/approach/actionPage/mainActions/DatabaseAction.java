package approach.actionPage.mainActions;

import approach.CurrentPage;
import approach.actionPage.ActionPage;
import approach.actionPage.actionsOnDatabase.AddAction;
import approach.actionPage.actionsOnDatabase.DeleteAction;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.ActionInput;
import fileio.Input;

public class DatabaseAction implements ActionPage {

    /**
     *
     * @param currentPage the current page I'm on
     * @param actionInput action information
     * @param input information about users, movies, actions
     * @param output final ArrayNode in which must be added
     * @return current page
     */
    @Override
    public CurrentPage resolveCommand(final CurrentPage currentPage, final ActionInput actionInput,
                                      final Input input, final ArrayNode output) {

        if (actionInput.getFeature().compareTo("add") == 0) {
            AddAction.add(actionInput, input, output);

        } else {
            DeleteAction.delete(actionInput, input, output);
        }

        return currentPage;
    }
}
