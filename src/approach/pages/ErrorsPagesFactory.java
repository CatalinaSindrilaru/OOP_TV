package approach.pages;

/**
 * Class that implements Factory Design Pattern for errors
 */
public class ErrorsPagesFactory {

    /**
     * Return new instance depending on type page
     * @param type type for page for which I need to verify errors
     * @return object that implements interface Errors
     */
    public Errors createPage(final String type) {

        if (type.compareTo("Homepage neautentificat") == 0) {
            return new UnauthenticatedHomepage();
        } else if (type.compareTo("Homepage autentificat") == 0) {
            return new AuthenticatedHomepage();
        } else {
            return new MoviesPage();
        }
    }
}
