package approach.observer;

public interface Observer {

    /**
     * Add a notification to the list of notifications for a user
     * @param movieTitle title of the movie that I want to be sent
     *                   in notification
     * @param message represent an ADD/DELETE action
     */
    void update(String movieTitle, String message);
}
