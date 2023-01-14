package approach;

import approach.filter.*;
import approach.filter.Sort;
import fileio.UserInput;
import fileio.MovieInput;
import fileio.Input;
import fileio.ActionInput;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Class that contains information about the current page like name, user that is logged
 * at the moment, and an array list with the movies that the actual user has
 */
public final class CurrentPage {
    private String pageName;
    private UserInput currentUser;

    private ArrayList<MovieInput> currentMovieList = new ArrayList<>();

    private Stack<CurrentPage> oldPages;


    public CurrentPage() {
        oldPages = new Stack<CurrentPage>();
    }

    public CurrentPage(CurrentPage currentPage) {
        this.pageName = currentPage.getPageName();
        this.currentUser = currentPage.currentUser;
        this.currentMovieList = new ArrayList<>(currentPage.getCurrentMovieList());
        this.oldPages = (Stack<CurrentPage>) currentPage.getOldPages().clone();
    }

    /**
     * @return pageName
     */
    public String getPageName() {
        return pageName;
    }

    /**
     * @param pageName new value
     */
    public void setPageName(final String pageName) {
        this.pageName = pageName;
    }

    /**
     * @return currentUser
     */
    public UserInput getCurrentUser() {
        return currentUser;
    }

    /**
     * @param currentUser new value
     */
    public void setCurrentUser(final UserInput currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * @return currentMovieList
     */
    public ArrayList<MovieInput> getCurrentMovieList() {
        return currentMovieList;
    }

    /**
     * @param currentMovieList new value
     */
    public void setCurrentMovieList(final ArrayList<MovieInput> currentMovieList) {
        this.currentMovieList = currentMovieList;
    }

    /**
     * Add all the movies that are not banned for the currentUser in the
     * currentMovieList
     * @param input input of the program
     */
    public void populateCurrentMoviesList(final Input input) {

        if (currentUser != null) {
            String countryUser = currentUser.getCredentials().getCountry();

            for (MovieInput movie : input.getMovies()) {
                ArrayList<String> countriesBanned = movie.getCountriesBanned();

                if (!countriesBanned.contains(countryUser)) {
                    currentMovieList.add(movie);
                }
            }
        }
    }

    /**
     * Deletes all the elements from the currentMovieList
     */
    public void clearCurrentMoviesList() {
        currentMovieList.clear();
    }

    /**
     * Filters the movies list by actors, genres, rating, duration
     * @param actionInput current action
     */
    public void filterMoviesList(final ActionInput actionInput) {

        if (actionInput.getFilters().getContains() != null) {
            Filter.filterContains(this, actionInput.getFilters().getContains());
        }

        /* Sort the movies */
        if (actionInput.getFilters().getSort() != null) {
            Sort.sortMovies(currentMovieList, actionInput.getFilters().getSort());
        }

    }

    /**
     * Find and return the movie that starts with the given word
     * @param prefix String
     * @return movie
     */
    public MovieInput findMovie(final String prefix) {

        if (currentMovieList.size() != 0) {
            for (MovieInput movie : currentMovieList) {
                if (movie.getName().startsWith(prefix)) {
                    return movie;
                }
            }
        }
        return null;
    }

    /**
     * Find all the movies that begins with the given prefix
     * @param prefix given string
     * @return ArrayList<MovieInput>
     */
    public ArrayList<MovieInput> searchByPrefix(final String prefix) {

        ArrayList<MovieInput> movies = new ArrayList<>();

        if (currentMovieList.size() != 0) {
            for (MovieInput movie : currentMovieList) {
                if (movie.getName().startsWith(prefix)) {
                    movies.add(movie);
                }
            }
        }
        return movies;
    }

    /**
     * @return oldPages
     */
    public Stack<CurrentPage> getOldPages() {
        return oldPages;
    }

}
