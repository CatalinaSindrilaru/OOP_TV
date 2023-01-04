package displays;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import approach.CurrentPage;

public final class DisplayCommand {

    private DisplayCommand() { }

    /**
     * Create the output for a command and add it to the final ArrayNode
     * @param output  final ArrayNode in which must be added
     * @param currentPage the current page I'm on
     */
    public static void writeInOutput(final ArrayNode output, final CurrentPage currentPage) {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode outputCommand = mapper.createObjectNode();

        ArrayNode currentMovieList
                = FormMoviesList.moviesListFormed(currentPage.getCurrentMovieList());

        ObjectNode currentUserFormed
                = FormCurrentUser.currentUserFormed(currentPage.getCurrentUser());

        outputCommand.set("error", null);
        outputCommand.set("currentMoviesList", currentMovieList);
        outputCommand.set("currentUser", currentUserFormed);

        output.add(outputCommand);
    }
}
