package approach.actionPage;

/**
 *  Class that implements Factory Design Pattern for actions
 */
public class ActionFactory {

    /**
     * Return new instance depending on type actions
     * @param type type of action (change / on)
     * @return object that implements interface ActionPage
     */
    public ActionPage createAction(final String type) {

        if (type.compareTo("change page") == 0) {
            return new ChangePage();
        } else if (type.compareTo("on page") == 0) {
            return new OnPage();
        } else if (type.compareTo("database") == 0) {
            return new DatabaseAction();
        } else {
            return new BackAction();
        }

    }
}
