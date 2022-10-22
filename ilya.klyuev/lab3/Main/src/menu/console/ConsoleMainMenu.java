package menu.console;

import controllers.PerformancesEmployeesController;
import input.console.ConsoleInput;
import menu.MainMenu;
import models.Performance;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleMainMenu implements MainMenu {
    private static final int MIN_MENU_ITEM = 1;
    private static final int END_MENU_ITEM = 6;
    private final PerformancesEmployeesController performancesEmployeesController;
    private final Logger logger;

    public ConsoleMainMenu(PerformancesEmployeesController performancesEmployeesController, Logger logger){
        this.performancesEmployeesController = performancesEmployeesController;
        this.logger = logger;
    }

    @Override
    public void show() {
        int menuItem = 0;
        ConsoleInput consoleInput = new ConsoleInput(logger);

        while (menuItem != END_MENU_ITEM){
            showMenu();
            menuItem = consoleInput.inputIntInRange("Выберите пункт", MIN_MENU_ITEM, END_MENU_ITEM);

            if (menuItem == 1){
                performancesEmployeesController.addEmployeesFromInputStream();
            }
            if (menuItem == 2){
                performancesEmployeesController.addEmployeesByRandom();
            }
            if (menuItem == 3){
                showPerformances();
            }
            if (menuItem == 4){
                showMaxPopularPerformances();
            }
            if (menuItem == 5) {
                showPerformancesNotTickets();
            }

            waitUser();
        }
    }

    private void showMenu(){
        System.out.println("1: Добавить выбранные билеты работников с консоли");
        System.out.println("2: Добавить выбранные билеты работников рандомно");
        System.out.println("3: Показать количество билетов на каждом спектале");
        System.out.println("4: Показать самые популярные спектакли");
        System.out.println("5: Показать спектали, на которые никто не купил билет");
        System.out.println("6: Выход");
    }

    private void showPerformance(Performance performance, int index){
        System.out.printf("%d: Название: %s, Количество билетов: %d\n", index, performance.getName(), performance.getTicketsCount());
    }

    private void showPerformances(){
        var performanceList = performancesEmployeesController.getPerformanceList();

        System.out.println("Спектакли:");

        int i = 1;
        for (var performance : performanceList){
            showPerformance(performance, i++);
        }
    }

    private void showMaxPopularPerformances(){
        var maxPopularPerformances = performancesEmployeesController.getMaxPopularPerformances();

        System.out.println("Самые популярые спектакли:");

        int i = 1;
        for (var performance : maxPopularPerformances){
            showPerformance(performance, i++);
        }
    }

    private void showPerformancesNotTickets(){
        var performancesNotTickets = performancesEmployeesController.getPerformancesNotTickets();

        System.out.println("Спектали, на которые не были куплены билеты");

        int i = 1;
        for (var performance : performancesNotTickets){
            showPerformance(performance, i++);
        }
    }

    private void waitUser(){
        System.out.println("Введите <ENTER>");
        try{
            System.in.read();
        } catch (IOException e){
            logger.log(Level.WARNING, "wait press enter", e);
        }
    }
}
