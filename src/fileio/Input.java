package fileio;

import java.util.ArrayList;

/**
 * Class that stores all the users, movies, actions
 * for the implementation
 */
public class Input {
    private ArrayList<UserInput> users;
    private ArrayList<MovieInput> movies;
    private ArrayList<ActionInput> actions;

    public Input() {

    }

    public Input(final ArrayList<UserInput> users, final ArrayList<MovieInput> movies,
                 final ArrayList<ActionInput> actions) {
        this.users = users;
        this.movies = movies;
        this.actions = actions;
    }

    /**
     * @return users
     */
    public ArrayList<UserInput> getUsers() {
        return users;
    }

    /**
     * @param users new value
     */
    public void setUsers(final ArrayList<UserInput> users) {
        this.users = users;
    }

    /**
     * @return movies
     */
    public ArrayList<MovieInput> getMovies() {
        return movies;
    }

    /**
     * @param movies new value
     */
    public void setMovies(final ArrayList<MovieInput> movies) {
        this.movies = movies;
    }

    /**
     * @return actions
     */
    public ArrayList<ActionInput> getActions() {
        return actions;
    }

    /**
     * @param actions new value
     */
    public void setActions(final ArrayList<ActionInput> actions) {
        this.actions = actions;
    }


    /**
     * Add new user to the list of users
     * @param user new user
     */
    public void addUser(final UserInput user) {
        users.add(user);
    }

    /**
     * Return the user with the given name and password or null
     * if it doesn't exist
     * @param credentials contains name and passord for a user
     * @return user
     */
    public UserInput findUser(final Credentials credentials) {

        for (UserInput user : users) {

            if (user.getCredentials().getName().compareTo(credentials.getName()) == 0) {

                if (user.getCredentials().getPassword()
                        .compareTo(credentials.getPassword()) == 0) {
                    return user;
                }
            }
        }

        return null;
    }

    /**
     * Verify if a movie exists in the databse
     * @param newMovieTitle title of the movie
     * @return true/false
     */
    public boolean findMovie(final String newMovieTitle) {

        for (MovieInput movie : movies) {
            if (movie.getName().compareTo(newMovieTitle) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Delete a movie from the database
     * @param movieTitle title of the movie that I want to delete
     */
    public void deleteMovie(final String movieTitle) {

        for (int i = 0; i < movies.size(); i++) {
            String title = movies.get(i).getName();
            if (title.compareTo(movieTitle) == 0) {
                movies.remove(i);
                return;
            }
        }
    }

    /**
     * Add a movie to the database
     * @param newMovie new movie
     */
    public void addMovie(final MovieInput newMovie) {
        this.movies.add(newMovie);
    }
}
