package displays;

import approach.actionPage.Notification;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.Credentials;
import fileio.Input;
import fileio.UserInput;

import java.text.Normalizer;
import java.util.ArrayList;

public final class FormCurrentUser {

    private FormCurrentUser() { }

    /**
     * Take a user and put it in an ObjectNode in the appropriate format
     * @param user user that is returned in the desired format
     * @return ObjectNode
     */
    public static ObjectNode currentUserFormed(final UserInput user) {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode userObjectNode = mapper.createObjectNode();

        ObjectNode credentials = credentialsFormed(user.getCredentials());

        ArrayNode purchasedMovies = FormMoviesList.moviesListFormed(user.getPurchasedMovies());
        ArrayNode watchedMovies = FormMoviesList.moviesListFormed(user.getWatchedMovies());
        ArrayNode likedMovie = FormMoviesList.moviesListFormed(user.getLikedMovies());
        ArrayNode ratedMovie = FormMoviesList.moviesListFormed(user.getRatedMovies());

//        ArrayList<String> notifications = user.getDatabaseNotifications().get(user.getCredentials().getName());
        ArrayList<Notification> notifications = user.getNotifications();
        ArrayNode notificationsArrayNode = notificationsFormed(notifications);

        userObjectNode.set("credentials", credentials);
        userObjectNode.put("tokensCount", user.getTokensCount());
        userObjectNode.put("numFreePremiumMovies", user.getNumFreePremiumMovies());
        userObjectNode.set("purchasedMovies", purchasedMovies);
        userObjectNode.set("watchedMovies", watchedMovies);
        userObjectNode.set("likedMovies", likedMovie);
        userObjectNode.set("ratedMovies", ratedMovie);
        userObjectNode.set("notifications", notificationsArrayNode);
        return userObjectNode;
    }

    /**
     * Take the credentials and put them in an ObjectNode in the appropriate format
     * @param credentials credentials that are returned in the desired format
     * @return ObjectNode
     */
    private static ObjectNode credentialsFormed(final Credentials credentials) {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode credentialsObjectNode = mapper.createObjectNode();

        credentialsObjectNode.put("name", credentials.getName());
        credentialsObjectNode.put("password", credentials.getPassword());
        credentialsObjectNode.put("accountType", credentials.getAccountType());
        credentialsObjectNode.put("country", credentials.getCountry());
        credentialsObjectNode.put("balance", credentials.getBalance());

        return credentialsObjectNode;
    }

    private static ArrayNode notificationsFormed(ArrayList<Notification> notifications) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode notificationsArrayNode = mapper.createArrayNode();

        for (Notification notification : notifications) {
            ObjectNode notificationObjectNode = mapper.createObjectNode();
            notificationObjectNode.put("movieName", notification.getMovieName());
            notificationObjectNode.put("message", notification.getMessage());

            notificationsArrayNode.add(notificationObjectNode);
        }

        return notificationsArrayNode;
    }
}
