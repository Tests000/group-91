import java.util.Scanner;

public class Tournament {
    private int getCountOfCommands() {
        Scanner in = new Scanner(System.in);
        System.out.println("Input count of commands");
        int result = in.nextInt();

        while (result<=0) {
            System.out.println("Input error! Count of commands must be positive number");
            result = in.nextInt();
        }

        return result;
    }

    public int calculateGames() {
        int countOfCommands = getCountOfCommands(); // Обработка ввода кол-ва команд

        int countOfGames = 0;

        while(countOfCommands != 1) {
            countOfGames += countOfCommands / 2;
            countOfCommands = (countOfCommands % 2 == 0) ?
                    countOfCommands / 2 :
                    countOfCommands / 2 + 1;
        }

        return countOfGames;
    }
}


