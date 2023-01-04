import approach.actionPage.ActionFactory;
import approach.actionPage.ActionPage;
import approach.CurrentPage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import displays.ErrorDisplay;
import fileio.ActionInput;
import fileio.Input;

import java.util.ArrayList;

/**
 * Class that starts the program by looking at all the
 * actions
 */
public final class StartProgram {

    // Singleton
    private static StartProgram instance = null;
    private StartProgram() {

    }

    /**
     * Returns the instance of a StartProgram class (Singleton)
     * @return StartProgram instance
     */
    public static StartProgram getInstance() {
        if (instance == null) {
            instance = new StartProgram();
        }
        return instance;
    }

    /**
     * Look at all the actions and identify the "change page"
     * and "on page" ones
     * @param input contains the users, movies, actions
     * @param output  final ArrayNode in which must be added
     */
    public void run(final Input input, final ArrayNode output) {

        ArrayList<ActionInput> actions = input.getActions();

        CurrentPage currentPage = new CurrentPage();
        currentPage.setPageName("Homepage neautentificat");

        for (ActionInput action : actions) {
            ActionFactory actionFactory = new ActionFactory();

            ActionPage actionPage;
            if (action.getType().compareTo("change page") == 0) {
                actionPage = actionFactory.createAction("change page");
                currentPage = actionPage.resolveCommand(currentPage, action, input, output);

            } else if (action.getType().compareTo("on page") == 0){
                actionPage = actionFactory.createAction("on page");
                currentPage = actionPage.resolveCommand(currentPage, action, input, output);

            } else if (action.getType().compareTo("database") == 0) {
                actionPage = actionFactory.createAction("database");
                currentPage = actionPage.resolveCommand(currentPage, action, input, output);
            }
            else {
                // back
                actionPage = actionFactory.createAction("back");
                currentPage = actionPage.resolveCommand(currentPage, action, input, output);

                currentPage.getOldPages().push(new CurrentPage(currentPage));
            }


        }

//        if (5 > 3) {
//            System.out.println("okkk");
//        }
    }

}
