package approach.events;

/**
 * Class that implements Factory Design Pattern for events
 */
public class EventsFactory {

    /**
     * Return new instance depending on type
     * @param type type of the event
     * @return object that implements interface Event
     */
    public Event createEvent(final String type) {

        if (type.compareTo("register") == 0) {
            return new RegisterEvent();

        } else if (type.compareTo("login") == 0) {
            return new LoginEvent();

        } else if (type.compareTo("filter") == 0) {
            return new FilterEvent();

        } else if (type.compareTo("search") == 0) {
            return  new SearchEvent();

        } else if (type.compareTo("buy tokens") == 0) {
            return new BuyTokensEvent();

        } else if (type.compareTo("buy premium account") == 0) {
            return new BuyPremiumAccountEvent();

        } else if (type.compareTo("purchase") == 0) {
            return new PurchaseEvent();

        } else if (type.compareTo("watch") == 0) {
            return new WatchEvent();

        } else if (type.compareTo("like") == 0) {
            return new LikeEvent();

        } else if (type.compareTo("rate") == 0) {
            return new RateEvent();

        } else if (type.compareTo("subscribe") == 0) {
            return new SubscribeEvent();
        }
        return null;
    }
}
