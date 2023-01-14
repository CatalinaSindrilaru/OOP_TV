package approach.observer;

import java.util.ArrayList;
import java.util.List;

public class Notifier implements  Subject {
    private final List<Observer> observers = new ArrayList<>();

    /**
     * Add new observer to the list of observers
     * @param o new observer
     */
    @Override
    public void addObserver(final Observer o) {
        observers.add(o);
    }

    /**
     * Update all the observers(users)
     * @param movieTitle title of the movie that I want to be sent
     *      *            in notification
     * @param message represent an ADD/DELETE action
     */
    @Override
    public void notifyAllObservers(final String movieTitle, final String message) {

        for (Observer o: observers) {
            o.update(movieTitle, message);
        }
    }
}
