package approach.actionPage.actionsOnDatabase;

import approach.observer.Notifier;
import approach.observer.UserObserver;
import com.fasterxml.jackson.databind.node.ArrayNode;
import displays.ErrorDisplay;
import fileio.ActionInput;
import fileio.Input;
import fileio.MovieInput;
import fileio.UserInput;

import java.util.ArrayList;

public final class DeleteAction {

    private DeleteAction() {

    }

    /**
     * Delete a movie from the database and send a notification
     * about it to the users
     * @param actionInput input for the action
     * @param input information about users, movies, actions
     * @param output final ArrayNode in which must be added
     */
    public static void delete(final ActionInput actionInput, final Input input,
                              final ArrayNode output) {

        String movieTitle = actionInput.getDeletedMovie();

        if (input.findMovie(movieTitle)) {

            input.deleteMovie(movieTitle);

            Notifier notifier = new Notifier();

            for (UserInput user : input.getUsers()) {

                ArrayList<MovieInput> purchasedMovies = user.getPurchasedMovies();
                MovieInput findMovie = searchInList(purchasedMovies, movieTitle);

                if (findMovie != null) {
                    UserObserver observer = new UserObserver(user);
                    notifier.addObserver(observer);
                    purchasedMovies.remove(findMovie);
                }

                if (searchInList(user.getLikedMovies(), movieTitle) != null) {
                    user.getLikedMovies().remove(findMovie);
                }

                if (searchInList(user.getWatchedMovies(), movieTitle) != null) {
                    user.getWatchedMovies().remove(findMovie);
                }

                if (searchInList(user.getRatedMovies(), movieTitle) != null) {
                    user.getRatedMovies().remove(findMovie);
                }
            }

            notifier.notifyAllObservers(movieTitle, "DELETE");

        } else {
            ErrorDisplay.displayError(output);
        }
    }

    /**
     * Search the movie with the given name in the given list
     * @param list where I want to look
     * @param movieTitle title of the movie I want to find
     * @return found movie / null
     */
    public static MovieInput searchInList(final ArrayList<MovieInput> list,
                                          final String movieTitle) {

        for (MovieInput movie : list) {
            if (movie.getName().compareTo(movieTitle) == 0) {
                return movie;
            }
        }

        return null;
    }
}
