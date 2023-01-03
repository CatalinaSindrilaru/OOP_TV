package approach.events;

import approach.CurrentPage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import displays.ErrorDisplay;
import fileio.ActionInput;
import fileio.Input;
import fileio.MovieInput;
import fileio.UserInput;

import java.util.ArrayList;

public class SubscribeEvent implements Event {
    @Override
    public void makeEvent(CurrentPage currentPage, ActionInput actionInput, Input input, ArrayNode output) {

        if (currentPage.getPageName().compareTo("see details") == 0) {
            UserInput currentUser = currentPage.getCurrentUser();
            MovieInput currentMovie = currentPage.getCurrentMovieList().get(0);

            ArrayList<String> genresCurrentMovie = currentMovie.getGenres();
            String subscribedGenre = actionInput.getSubscribedGenre();

            if (genresCurrentMovie.contains(subscribedGenre)) {
                if (currentUser.getSubscribedGenres().size() != 0) {
                    if (!currentUser.getSubscribedGenres().contains(subscribedGenre)) {
                        currentUser.addSubscribedGenre(subscribedGenre);
                    } else {
                        ErrorDisplay.displayError(output);
                    }
                } else {
                    currentUser.addSubscribedGenre(subscribedGenre);
                }
            } else {
                ErrorDisplay.displayError(output);
            }
        } else {
            ErrorDisplay.displayError(output);
        }
    }
}
