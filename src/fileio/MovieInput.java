package fileio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that contains information about a movie
 */
public class MovieInput {

    private String name;
    private String year;
    private int duration;
    private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;

    /* Number of likes for a movie */
    private int numLikes = 0;
    /* Rating for a movie*/
    private float rating = 0;
    /* Number of ratings provided by users*/
    private int numRatings = 0;
    /* Sum of the ratings provided by all the users*/
//    private int sumRatings = 0;

    private HashMap<String, Integer> ratings = new HashMap<>();

    public MovieInput(MovieInput movieInput) {
        this.name = movieInput.getName();
        this.year = movieInput.getYear();
        this.duration = movieInput.getDuration();
        this.genres = new ArrayList<>(movieInput.getGenres());
        this.actors = new ArrayList<>(movieInput.getActors());
        this.countriesBanned = new ArrayList<>(movieInput.getCountriesBanned());
        this.numLikes = movieInput.getNumLikes();
        this.rating = movieInput.getRating();
        this.numRatings = movieInput.getNumRatings();
//        this.sumRatings = movieInput.getSumRatings();
        this.ratings = new HashMap<>();
        this.ratings.putAll(movieInput.getRatings());
    }

    public MovieInput() {

    }

    public MovieInput(final String name, final String year, final int duration,
                      final ArrayList<String> genres, final ArrayList<String> actors,
                      final ArrayList<String> countriesBanned) {
        this.name = name;
        this.year = year;
        this.duration = duration;
        this.genres = genres;
        this.actors = actors;
        this.countriesBanned = countriesBanned;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name new value
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year new value
     */
    public void setYear(final String year) {
        this.year = year;
    }

    /**
     * @return duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration new value
     */
    public void setDuration(final int duration) {
        this.duration = duration;
    }

    /**
     * @return genres
     */
    public ArrayList<String> getGenres() {
        return genres;
    }

    /**
     * @param genres new value
     */
    public void setGenres(final ArrayList<String> genres) {
        this.genres = genres;
    }

    /**
     * @return actors
     */
    public ArrayList<String> getActors() {
        return actors;
    }

    /**
     * @param actors new value
     */
    public void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }

    /**
     * @return countriesBanned
     */
    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }

    /**
     * @param countriesBanned new value
     */
    public void setCountriesBanned(final ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }

    /**
     * @return numLikes
     */
    public int getNumLikes() {
        return numLikes;
    }

    /**
     * @param numLikes new value
     */
    public void setNumLikes(final int numLikes) {
        this.numLikes = numLikes;
    }

    /**
     * @return rating
     */
    public float getRating() {
        return rating;
    }

    /**
     * @param rating new value
     */
    public void setRating(final float rating) {
        this.rating = rating;
    }

    /**
     * @return numRatings
     */
    public int getNumRatings() {
        return numRatings;
    }

    /**
     * @param numRatings new value
     */
    public void setNumRatings(final int numRatings) {
        this.numRatings = numRatings;
    }

    /**
     * @return sumRatings
     */
//    public int getSumRatings() {
//        return sumRatings;
//    }

    /**
     * @param sumRatings new value
     */
//    public void setSumRatings(final int sumRatings) {
//        this.sumRatings = sumRatings;
//    }


    public HashMap<String, Integer> getRatings() {
        return ratings;
    }

    public void setRatings(HashMap<String, Integer> ratings) {
        this.ratings = ratings;
    }

    public boolean bannedForUser(UserInput user) {
        String country = user.getCredentials().getCountry();
        return countriesBanned.contains(country);
    }
}
