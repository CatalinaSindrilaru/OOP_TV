package approach.observer;

public interface Subject {

    /**
     * Add new observer to the list of observers
     * @param o new observer
     */
    void addObserver(Observer o);


    /**
     * Update all the observers(users)
     * @param movieTitle title of the movie that I want to be sent
     *      *            in notification
     * @param message represent an ADD/DELETE action
     */
    void notifyAllObservers(String movieTitle, String message);
}
