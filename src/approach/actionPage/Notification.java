package approach.actionPage;

public class Notification {
    private String movieName;
    private String message;

    public Notification(final String movieName, final String message) {
        this.movieName = movieName;
        this.message = message;
    }

    /**
     * @return movie name
     */
    public String getMovieName() {
        return movieName;
    }

    /**
     * @param movieName new value
     */
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    /**
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message new value
     */
    public void setMessage(final String message) {
        this.message = message;
    }
}
