package approach.actionPage;

import approach.CurrentPage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.ActionInput;
import fileio.Input;

/**
 * Interface for an action page ("change page", "on page")
 */
public interface ActionPage {
    CurrentPage resolveCommand(CurrentPage currentPage, ActionInput actionInput,
                               Input input, ArrayNode output);
}
