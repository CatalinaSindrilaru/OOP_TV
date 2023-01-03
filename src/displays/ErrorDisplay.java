package displays;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;

public final class ErrorDisplay {

    private ErrorDisplay() { }

    /**
     * Display an error message with message "Error", empty list of movies and null user
     * @param output final ArrayNode in which must be added
     */
    public static void displayError(final ArrayNode output) {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode outputCommand = mapper.createObjectNode();

        ArrayNode currentMovieList
                = FormMoviesList.moviesListFormed(new ArrayList<>());

        outputCommand.put("error", "Error");
        outputCommand.set("currentMoviesList", currentMovieList);
        outputCommand.set("currentUser", null);

        output.add(outputCommand);
    }
}
