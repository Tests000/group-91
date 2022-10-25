package menu.console;

import input.console.ConsoleInput;
import menu.StartMenu;
import menu.StartMenuDialogResult;

import java.util.logging.Logger;

public class ConsoleStartMenu implements StartMenu {

    private static final int START_MENU_ITEM = 1;
    private static final int END_MENU_ITEM = 3;
    private final Logger logger;

    public ConsoleStartMenu(Logger logger){

        this.logger = logger;
    }

    @Override
    public StartMenuDialogResult showDialog() {
        int menuItem = 0;
        ConsoleInput consoleInput = new ConsoleInput(logger);

        while (menuItem != END_MENU_ITEM){
            showMenu();
            menuItem = consoleInput.inputIntInRange("Выберите пункт", START_MENU_ITEM, END_MENU_ITEM);

            if (menuItem == 1){
                return StartMenuDialogResult.USERMODE;
            }
            if (menuItem == 2){
                return StartMenuDialogResult.TESTMODE;
            }
        }

        return StartMenuDialogResult.EXIT;
    }

    private void showMenu() {
        System.out.println("1: Режим пользователя");
        System.out.println("2: Протестировать время работы ArrayList, LinkedList и Vector");
        System.out.println("3: Выход");
    }
}
