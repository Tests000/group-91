import controllers.PerformancesEmployeesController;
import factories.ListChoice;
import factories.ListFactory;
import input.console.ConsoleEmployeesAddFromInputStream;
import input.random.RandomEmployeeAdd;
import menu.MainMenu;
import menu.StartMenu;
import menu.StartMenuDialogResult;
import menu.console.ConsoleMainMenu;
import menu.console.ConsoleStartMenu;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getGlobal();
    private static final int DEFAULT_PERFORMANCES_COUNT = 8;

    public static void main(String[] args) {

        StartMenu startMenu = new ConsoleStartMenu(LOGGER);
        StartMenuDialogResult startMenuDialogResult = startMenu.showDialog();

        if (startMenuDialogResult == StartMenuDialogResult.USERMODE){
            startUserMode();
        } else if (startMenuDialogResult == StartMenuDialogResult.TESTMODE){
            startTestMode();
        }
    }

    private static void startUserMode(){
        ListFactory.selectList(ListChoice.ARRAYLIST);

        PerformancesEmployeesController performancesEmployeesController = new PerformancesEmployeesController(
                new ConsoleEmployeesAddFromInputStream(LOGGER),
                new RandomEmployeeAdd(),
                DEFAULT_PERFORMANCES_COUNT
        );
        MainMenu mainMenu = new ConsoleMainMenu(performancesEmployeesController, LOGGER);
        mainMenu.show();
    }

    private static void startTestMode(){
        ListFactory.selectList(ListChoice.ARRAYLIST);
        long executionTimeWithArrayList = TestTime.Test();
        System.out.printf("ArrayList ms: %d\n", executionTimeWithArrayList);

        ListFactory.selectList(ListChoice.LINKEDLIST);
        long executionTimeWithLinkedList = TestTime.Test();
        System.out.printf("LinkedList ms: %d\n", executionTimeWithLinkedList);

        if (executionTimeWithArrayList < executionTimeWithLinkedList) {
            System.out.println("ArrayList выгоднее использовать для данной задачи");
        } else {
            System.out.println("LinkedList выгоднее использовать для данной задачи");
        }
    }
}