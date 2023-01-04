package approach.actionPage;

import approach.CurrentPage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import displays.ErrorDisplay;
import fileio.ActionInput;
import fileio.Input;
import fileio.MovieInput;
import fileio.UserInput;

import java.util.ArrayList;

public class DatabaseAction implements ActionPage {

    /**
     *
     * @param currentPage the current page I'm on
     * @param actionInput action information
     * @param input information about users, movies, actions
     * @param output final ArrayNode in which must be added
     * @return current page
     */
    @Override
    public CurrentPage resolveCommand(final CurrentPage currentPage, final ActionInput actionInput,
                                      final Input input, final ArrayNode output) {

        if (actionInput.getFeature().compareTo("add") == 0) {
            MovieInput newMovie = actionInput.getAddedMovie();

            if (input.findMovie(newMovie.getName())) {
                ErrorDisplay.displayError(output);
            } else {
                input.addMovie(newMovie);

                ArrayList<String> movieGenres = newMovie.getGenres();

                ArrayList<UserInput> users = input.getUsers();
                for (UserInput user : users) {
                    ArrayList<String> userGenres = user.getSubscribedGenres();

                    boolean userSubscribed = false;
                    for (String genre : userGenres) {
                        if (movieGenres.contains(genre)) {
                            userSubscribed = true;
                            break;
                        }
                    }

                    if (newMovie.bannedForUser(user)) {
                        userSubscribed = false;
                    }

                    if (userSubscribed) {
                        Notification notification = new Notification(newMovie.getName(), "ADD");
                        user.addNotification(notification);
                    }
                }
            }

        } else {

            String movieTitle = actionInput.getDeletedMovie();

            if (input.findMovie(movieTitle)) {
                input.deleteMovie(movieTitle);

                ArrayList<UserInput> users = input.getUsers();
                for (UserInput user : users) {

                    ArrayList<MovieInput> purchasedMovies = user.getPurchasedMovies();
                    MovieInput findMovie = searchInList(purchasedMovies, movieTitle);

                    if (findMovie != null) {
                        Notification notification = new Notification(findMovie.getName(), "DELETE");
                        user.addNotification(notification);
                        purchasedMovies.remove(findMovie);
                    }

                    findMovie = searchInList(user.getLikedMovies(), movieTitle);
                    if (findMovie != null) {
                        user.getLikedMovies().remove(findMovie);
                    }

                    findMovie = searchInList(user.getWatchedMovies(), movieTitle);
                    if (findMovie != null) {
                        user.getWatchedMovies().remove(findMovie);
                    }

                    findMovie = searchInList(user.getRatedMovies(), movieTitle);
                    if (findMovie != null) {
                        user.getRatedMovies().remove(findMovie);
                    }

                }


            } else {
                ErrorDisplay.displayError(output);
            }
        }
        return currentPage;
    }

    public MovieInput searchInList(final ArrayList<MovieInput> list, final String movieTitle) {

        for (MovieInput movie : list) {
            if (movie.getName().compareTo(movieTitle) == 0) {
                return movie;
            }
        }

        return null;
    }
}
