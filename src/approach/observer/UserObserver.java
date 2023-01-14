package approach.observer;

import approach.actionPage.Notification;
import fileio.UserInput;

public class UserObserver implements Observer {

    private UserInput user;

    public UserObserver(final UserInput user) {
        this.user = user;
    }

    /**
     * Add a notification to the list of notifications for a user
     * @param movieTitle title of the movie that I want to be sent
     *                   in notification
     * @param message represent an ADD/DELETE action
     */
    @Override
    public void update(final String movieTitle, final String message) {

        Notification notification = new Notification(movieTitle, message);
        user.addNotification(notification);
    }

    /**
     * @return user
     */
    public UserInput getUser() {
        return user;
    }

    /**
     * @param user new value
     */
    public void setUser(final UserInput user) {
        this.user = user;
    }
}
