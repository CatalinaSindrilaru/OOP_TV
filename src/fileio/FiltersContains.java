package fileio;

import java.util.ArrayList;

/**
 * Contains a list of actors and a list of genres according to which
 * can filter the list of movies
 */
public class FiltersContains {
    private ArrayList<String> actors;
    private ArrayList<String> genre;

    public FiltersContains() {

    }

    public FiltersContains(final ArrayList<String> actors, final ArrayList<String> genre) {
        this.actors = actors;
        this.genre = genre;
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
     * @return genre
     */
    public ArrayList<String> getGenre() {
        return genre;
    }

    /**
     * @param genre new value
     */
    public void setGenre(final ArrayList<String> genre) {
        this.genre = genre;
    }
}
