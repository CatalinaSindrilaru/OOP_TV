package displays;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.MovieInput;

import java.util.ArrayList;

public final class FormMovie {

    private FormMovie() { }

    /**
     * Take a movie and return it as an ObjectNode in the appropriate format
     * @param movie movie that is returned in the desired format
     * @return ObjectNode with the movie
     */
    public static ObjectNode movieFormed(final MovieInput movie) {

        ObjectMapper mapper = new ObjectMapper();

        ArrayNode genres = stringListFormed(movie.getGenres());
        ArrayNode actors = stringListFormed(movie.getActors());
        ArrayNode countriesBanned = stringListFormed(movie.getCountriesBanned());

        ObjectNode movieObjectNode = mapper.createObjectNode();

        movieObjectNode.put("name", movie.getName());
        movieObjectNode.put("year", movie.getYear());
        movieObjectNode.put("duration", movie.getDuration());
        movieObjectNode.set("genres", genres);
        movieObjectNode.set("actors", actors);
        movieObjectNode.set("countriesBanned", countriesBanned);
        movieObjectNode.put("numLikes", movie.getNumLikes());
        movieObjectNode.put("rating", movie.getRating());
        movieObjectNode.put("numRatings", movie.getNumRatings());

        return movieObjectNode;
    }

    /**
     * Take the list of Strings and put it in an ArrayNode
     * @param list list of Strings
     * @return ArrayNode
     */
    public static ArrayNode stringListFormed(final ArrayList<String> list) {

        ObjectMapper mapper = new ObjectMapper();
        ArrayNode listArrayNode = mapper.createArrayNode();

        if (list != null) {
            for (String s : list) {
                listArrayNode.add(s);
            }
        }

        return listArrayNode;
    }
}
