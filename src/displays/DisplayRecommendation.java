package displays;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.UserInput;

public class DisplayRecommendation {

    private DisplayRecommendation() {

    }

    /**
     * Write in output the final recommendation for a user
     * @param user user that need a recommendation
     * @param output final ArrayNode in which must be added
     */
    public static void display(final UserInput user, final ArrayNode output) {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode outputCommand = mapper.createObjectNode();

        ObjectNode userObjectNode = FormCurrentUser.currentUserFormed(user);

        outputCommand.set("error", null);
        outputCommand.set("currentMoviesList", null);
        outputCommand.set("currentUser", userObjectNode);

        output.add(outputCommand);
    }
}
