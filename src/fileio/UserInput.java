package fileio;

import approach.actionPage.Notification;

import java.net.NoRouteToHostException;
import java.util.ArrayList;

/**
 * Contains information about a user
 */
public class UserInput {

    public static final int MAX_NUMBER_FREE_MOVIES = 15;
    private Credentials credentials;

    /* the number of tokens the user currently has */
    private int tokensCount = 0;

    /* the number of free movies available in the case of a premium account
     that the user still has at his disposal */
    private int numFreePremiumMovies = MAX_NUMBER_FREE_MOVIES;

    /* movies purchased by the user */
    private ArrayList<MovieInput> purchasedMovies = new ArrayList<>();

    /* the movies viewed by the user  */
    private ArrayList<MovieInput> watchedMovies = new ArrayList<>();

    /* movies rated by the user */
    private ArrayList<MovieInput> likedMovies = new ArrayList<>();

    /* movies that the current user has rated */
    private ArrayList<MovieInput> ratedMovies = new ArrayList<>();

    private ArrayList<Notification> notifications;
    private ArrayList<String> subscribedGenres;

    public UserInput() {
        notifications = new ArrayList<>();
        subscribedGenres = new ArrayList<>();
    }

    public UserInput(final Credentials credentials, final int tokensCount,
                     final int numFreePremiumMovies, final ArrayList<MovieInput> purchasedMovies,
                     final ArrayList<MovieInput> watchedMovies,
                     final ArrayList<MovieInput> likedMovies,
                     final ArrayList<MovieInput> ratedMovies) {
        this.credentials = credentials;
        this.tokensCount = tokensCount;
        this.numFreePremiumMovies = numFreePremiumMovies;
        this.purchasedMovies = purchasedMovies;
        this.watchedMovies = watchedMovies;
        this.likedMovies = likedMovies;
        this.ratedMovies = ratedMovies;
    }

    public UserInput(UserInput userInput) {

            this.credentials = new Credentials(userInput.getCredentials());
            this.tokensCount = userInput.getTokensCount();
            this.numFreePremiumMovies = userInput.getNumFreePremiumMovies();
            this.purchasedMovies = new ArrayList<>(userInput.getPurchasedMovies());
            this.watchedMovies = new ArrayList<>(userInput.getWatchedMovies());
            this.likedMovies = new ArrayList<>(userInput.getLikedMovies());
            this.ratedMovies = new ArrayList<>(userInput.getRatedMovies());
            this.notifications = new ArrayList<>(userInput.getNotifications());
            this.subscribedGenres = new ArrayList<>(userInput.getSubscribedGenres());

    }

    /**
     * @return credentials
     */
    public Credentials getCredentials() {
        return credentials;
    }

    /**
     * @param credentials new value
     */
    public void setCredentials(final Credentials credentials) {
        this.credentials = credentials;
    }

    /**
     * @return tokensCount
     */
    public int getTokensCount() {
        return tokensCount;
    }

    /**
     * @param tokensCount new value
     */
    public void setTokensCount(final int tokensCount) {
        this.tokensCount = tokensCount;
    }

    /**
     * @return numFreePremiumMovies
     */
    public int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }

    /**
     * @param numFreePremiumMovies new value
     */
    public void setNumFreePremiumMovies(final int numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }

    /**
     * @return purchasedMovies
     */
    public ArrayList<MovieInput> getPurchasedMovies() {
        return purchasedMovies;
    }

    /**
     * @param purchasedMovies new value
     */
    public void setPurchasedMovies(final ArrayList<MovieInput> purchasedMovies) {
        this.purchasedMovies = purchasedMovies;
    }

    /**
     * @return watchedMovies
     */
    public ArrayList<MovieInput> getWatchedMovies() {
        return watchedMovies;
    }

    /**
     * @param watchedMovies new value
     */
    public void setWatchedMovies(final ArrayList<MovieInput> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    /**
     * @return likedMovies
     */
    public ArrayList<MovieInput> getLikedMovies() {
        return likedMovies;
    }

    /**
     * @param likedMovies new value
     */
    public void setLikedMovies(final ArrayList<MovieInput> likedMovies) {
        this.likedMovies = likedMovies;
    }

    /**
     * @return ratedMovies
     */
    public ArrayList<MovieInput> getRatedMovies() {
        return ratedMovies;
    }

    /**
     * @param ratedMovies new value
     */
    public void setRatedMovies(final ArrayList<MovieInput> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }

    /**
     * Add a movie at the list of purchased movies of a user
     * @param movie new movie
     */
    public void addAtPurchasedMovies(final MovieInput movie) {
        this.purchasedMovies.add(movie);
    }

    /**
     * Add a movie at the list of watched movies of a user
     * @param movie new movie
     */
    public void addAtWatchedMovies(final MovieInput movie) {
        this.watchedMovies.add(movie);
    }

    /**
     * Add a movie at the list of liked movies of a user
     * @param movie new user
     */
    public void addAtLikedMovies(final MovieInput movie) {
        this.likedMovies.add(movie);
    }

    /**
     * Add a movie at the list of rated movies of a user
     * @param movie new movie
     */
    public void addAtRatedMovies(final MovieInput movie) {
        this.ratedMovies.add(movie);
    }


    /**
     * Verify if the movie was purchased or not
     * @param purchasedMovie movie that needs to be verified
     * @return true/false
     */
    public boolean purchasedMovie(final MovieInput purchasedMovie) {

        for (MovieInput movie : purchasedMovies) {
            if (movie.getName().compareTo(purchasedMovie.getName()) == 0) {
                return true;
            }
        }

        return false;
    }

    /**
     * Verify if the movie was watched or not
     * @param watchedMovie movie that needs to be verified
     * @return true/false
     */
    public boolean watchedMovie(final MovieInput watchedMovie) {

        for (MovieInput movie : watchedMovies) {
            if (movie.getName().compareTo(watchedMovie.getName()) == 0) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<Notification> notifications) {
        this.notifications = notifications;
    }

    public ArrayList<String> getSubscribedGenres() {
        return subscribedGenres;
    }

    public void setSubscribedGenres(ArrayList<String> subscribedGenres) {
        this.subscribedGenres = subscribedGenres;
    }

    public void addNotification(Notification notification) {
        this.notifications.add(notification);
    }

    public void addSubscribedGenre(String genre) {
        this.subscribedGenres.add(genre);
    }

}
