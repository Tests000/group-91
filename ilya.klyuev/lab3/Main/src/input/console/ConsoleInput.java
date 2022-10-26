package input.console;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleInput {
    private final Logger logger;

    public ConsoleInput(Logger logger){
        this.logger = logger;
    }

    public int inputIntInRange(String message, int leftBound, int rightBound) {
        System.out.println(message);

        int number = 0;
        boolean isCorrectInput = false;
        Scanner scanner = new Scanner(System.in);

        while (!isCorrectInput){
            try{
                System.out.printf("Введите число от %d до %d\n", leftBound, rightBound);
                number = scanner.nextInt();
                if (number >= leftBound && number <= rightBound){
                    isCorrectInput = true;
                } else{
                    logger.info("InputIntInRange число не входит в заданный диапазон");
                }

            } catch (Exception e){
                scanner.nextLine();
                logger.log(Level.WARNING, "Ошибка ввода", e);
            }
        }

        return number;
    }
}