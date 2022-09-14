import java.util.Scanner;

public class CorrectInput {
    Scanner scanner = new Scanner(System.in);

    private int InputInt() {
        int number = 0;
        boolean isCorrectInput = false;

        while (!isCorrectInput) {
            try {
                number = scanner.nextInt();
                isCorrectInput = true;
            } catch (Exception exception){
                System.out.println("Произошла ошибка при вводе. Повторите попытку");
                scanner.nextLine();
            }
        }
        return number;
    }

    public int InputIntInRange(String message, int leftBound, int rightBound) {
        int number = 0;
        boolean isCorrectInput = false;

        while (!isCorrectInput) {
            System.out.println(message);
            System.out.printf("Введите число от %d до %d\n", leftBound, rightBound);
            number = InputInt();
            isCorrectInput = number >= leftBound && number <= rightBound;
            if (!isCorrectInput)
                System.out.println("Число не входит в заданный диапазон. Повторите попытку");
        }
        return number;
    }
}
