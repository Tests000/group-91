import classes.TransportModelArrayList;
import classes.TransportModelLinkedList;

import java.util.Scanner;

public class Main {
    private static final int DAYS_CONST = 7;
    private static final int ROUTE_CONST = 10;
    private static final int MIN_CONST = 0;
    private static final int MAX_CONST = 15000;

    public static void main(String[] args) {
        boolean exit = false;
        int answer;
        int [][] inputArray = new int[DAYS_CONST][ROUTE_CONST];
        while(!exit){
            System.out.println("Выберите способ введения данных:");
            System.out.println("1. Ввесть данные с консоли.");
            System.out.println("2. Ввести рандомные данные.");
            System.out.println("Для выхода введите любое другое число.");

            Scanner input = new Scanner(System.in);
            while (!input.hasNextInt()) {
                System.out.println("Введено не int значение");
                input.next();
            }
            answer = input.nextInt();


            switch (answer){
                case 1:
                    inputArray = inputConsole();
                    break;
                case 2:
                    inputArray = inputRandom();
                    break;
                default:
                    exit = true;
                    break;
            }
            if(!exit) {
                TransportModelLinkedList ll = new TransportModelLinkedList();
                TransportModelArrayList al = new TransportModelArrayList();
                long startTime = System.currentTimeMillis();
                ll.input(inputArray);
                ll.sumWeekRoute();
                ll.outputWeek();
                long timeSpeedLl = System.currentTimeMillis() - startTime;

                startTime = System.currentTimeMillis();
                al.input(inputArray);
                al.sumWeekRoute();
                al.outputWeek();
                long timeSpeedAl = System.currentTimeMillis() - startTime;
                System.out.println("Скорость для LinkedList: " + timeSpeedLl);
                System.out.println("Скорость для ArrayList: " + timeSpeedAl);
            }
        }

    }

    public static boolean inputCheck(final int minValue, final int maxValue, int inputValue) {
        return (minValue > inputValue || inputValue > maxValue);
    }

    public static int[][] inputConsole(){
        int [][] consoleArray = new int[DAYS_CONST][ROUTE_CONST];
        for(int i = 0; i < DAYS_CONST; i++){
            System.out.println("Введите выручку за " + (i+1) + " день: ");
            for(int j = 0; j < ROUTE_CONST; j++){
                System.out.println("Введите выручку для " + (j+1) + " маршута: (от 0 до 15000)");
                Scanner input = new Scanner(System.in);
                while (!input.hasNextInt()) {
                    System.out.println("Введено не int значение");
                    input.next();
                }
                consoleArray[i][j] = input.nextInt();

                while (inputCheck(MIN_CONST, MAX_CONST, consoleArray[i][j])) {
                    System.out.println("Введите выручку для " + (j+1) + " маршута: (от 0 до 15000)");
                    while (!input.hasNextInt()) {
                        System.out.println("Введено не int значение");
                        input.next();
                    }
                    consoleArray[i][j] = input.nextInt();
                }
            }
        }
        return consoleArray;
    }

    public static int[][] inputRandom(){
        int [][] randomArray = new int[DAYS_CONST][ROUTE_CONST];
        for(int i = 0; i < DAYS_CONST; i++){
            for(int j = 0; j < ROUTE_CONST; j++){
                randomArray[i][j] = (int)((Math.random() * (MAX_CONST - MIN_CONST)) + MIN_CONST);
            }
        }
        return randomArray;
    }


}
