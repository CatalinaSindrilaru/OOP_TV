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

public final class AddAction {

    private AddAction() {

    }

    /**
     * Add a new movie to the database and send a notification about it
     * to the subscribed users
     * @param actionInput input for the action
     * @param input information about users, movies, actions
     * @param output final ArrayNode in which must be added
     */
    public static void add(final ActionInput actionInput, final Input input,
                           final ArrayNode output) {

        MovieInput newMovie = actionInput.getAddedMovie();

        if (input.findMovie(newMovie.getName())) {
            ErrorDisplay.displayError(output);

        } else {
            input.addMovie(newMovie);

            Notifier notifier = new Notifier();

            for (UserInput user : input.getUsers()) {
                ArrayList<String> userGenres = user.getSubscribedGenres();
                boolean userSubscribed = false;

                if (!newMovie.bannedForUser(user)) {
                    for (String genre : userGenres) {
                        if (newMovie.getGenres().contains(genre)) {
                            userSubscribed = true;
                            break;
                        }
                    }
                }

                if (userSubscribed) {
                    UserObserver observer = new UserObserver(user);
                    notifier.addObserver(observer);
                }
            }

            notifier.notifyAllObservers(newMovie.getName(), "ADD");
        }
    }
}
