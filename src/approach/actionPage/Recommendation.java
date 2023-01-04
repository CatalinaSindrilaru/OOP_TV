package approach.actionPage;

import approach.CurrentPage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import displays.DisplayRecommendation;
import fileio.Input;
import fileio.MovieInput;
import fileio.UserInput;

import java.util.*;

public class Recommendation {

    private Recommendation() {

    }

    /**
     * Go through all the movies and find the perfect one to be recommended
     * @param input  information about users, movies, actions
     * @param currentPage the current page I'm on
     * @param output final ArrayNode in which must be added
     */
    public static void addRecommendation(final Input input, final CurrentPage currentPage,
                                         final ArrayNode output) {

        UserInput user = currentPage.getCurrentUser();
        if (user == null || user.getCredentials().getAccountType().compareTo("standard") == 0) {
            return;
        }

        currentPage.clearCurrentMoviesList();
        currentPage.populateCurrentMoviesList(input);

        HashMap<String, Integer> genresLikes = new HashMap<>();

        ArrayList<MovieInput> likedMovies = user.getLikedMovies();

        for (MovieInput movie : likedMovies) {
            ArrayList<String> movieGenres = movie.getGenres();

            for (String movieGenre : movieGenres) {
                if (genresLikes.containsKey(movieGenre)) {
                    Integer oldLikes = genresLikes.get(movieGenre);
                    genresLikes.put(movieGenre, oldLikes + 1);
                } else {
                    genresLikes.put(movieGenre, 1);
                }
            }

        }

        /* Sort the list of genres */
        ArrayList<String> sortedGenresList = sortByValue(genresLikes);

        /* Sort the movies from the database */
        ArrayList<MovieInput> moviesFromDatabase = currentPage.getCurrentMovieList();
        moviesFromDatabase.sort(Comparator.comparingInt(MovieInput::getNumLikes));

        MovieInput wantedMovie = null;
        for (String genre : sortedGenresList) {

            for (MovieInput movie : moviesFromDatabase) {
                if (!user.getWatchedMovies().contains(movie)) {
                    ArrayList<String> movieGenres = movie.getGenres();

                    for (String movieGenre : movieGenres) {
                        if (movieGenre.compareTo(genre) == 0) {
                            wantedMovie = movie;
                            break;
                        }
                    }
                }
            }
        }

        Notification notification;
        if (wantedMovie != null) {
            notification = new Notification(wantedMovie.getName(), "Recommendation");
        } else {
            notification = new Notification("No recommendation", "Recommendation");
        }
        user.addNotification(notification);

        DisplayRecommendation.display(user, output);
    }

    private static ArrayList<String> sortByValue(final HashMap<String, Integer> map) {

        List<Map.Entry<String, Integer>> list
                = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(final Map.Entry<String, Integer> o1,
                               final Map.Entry<String, Integer> o2) {
                if (o2.getValue().compareTo(o1.getValue()) != 0) {
                    return o2.getValue().compareTo(o1.getValue());
                } else {
                    return o1.getKey().compareTo(o2.getKey());
                }

            }
        });

        ArrayList<String> sortedGenresList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : list) {
            if (entry.getValue() != 0) {
                sortedGenresList.add(entry.getKey());
            }
        }
        return sortedGenresList;
    }

}
