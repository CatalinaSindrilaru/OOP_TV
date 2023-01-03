package approach.pages;

import approach.CurrentPage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.ActionInput;

/**
 * Interface for errors (for important pages)
 */
public interface Errors {

    boolean checkErrors(CurrentPage currentPage, ActionInput actionInput, ArrayNode output);
}
