package displays;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.MovieInput;

import java.util.ArrayList;

public final class FormMoviesList {

    private FormMoviesList() { }

    /**
     * Form an ArrayNode that contains all the movies from the given list
     * in the appropriate format
     * @param movies list of movies
     * @return ArrayNode
     */
    public static ArrayNode moviesListFormed(final ArrayList<MovieInput> movies) {

        ObjectMapper mapper = new ObjectMapper();
        ArrayNode listFormed = mapper.createArrayNode();

        for (MovieInput movie : movies) {
            ObjectNode movieFormed = FormMovie.movieFormed(movie);
            listFormed.add(movieFormed);
        }

        return listFormed;
    }
}
