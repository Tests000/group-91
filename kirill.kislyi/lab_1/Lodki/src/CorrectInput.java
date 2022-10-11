import java.util.Scanner;


public class CorrectInput {
    private int inputInt() {
        int number = 0;
        boolean isCorrectInput = false;
        Scanner scanner = new Scanner(System.in);

        while (!isCorrectInput) {
            try {
                number = scanner.nextInt();
                isCorrectInput = true;
            } catch (Exception exception) {
                System.out.println("Произошла ошибка при вводе. Повторите попытку");
                scanner.nextLine();
                exception.printStackTrace();
            }
        }
        return number;
    }

    public int inputIntInRange(String message, int leftBound, int rightBound) {
        int number = 0;
        boolean isCorrectInput = false;

        while (!isCorrectInput) {
            System.out.println(message);
            System.out.printf("Введите число в диапазоне [%d ; %d]\n", leftBound, rightBound);
            number = inputInt();
            isCorrectInput = number >= leftBound && number <= rightBound;
            if (!isCorrectInput) {
                System.out.println("Число не входит диапазон. Повторите попытку");
            }
        }
        return number;
    }

    public int[] inputWeights() {
        int peoplesCount = inputIntInRange("Введите число людей", 1, 30);
        int[] weights = new int[peoplesCount];

        for (int i = 0; i < peoplesCount; i++) {
            String message = String.format("Введите вес %d -го человека", i + 1);
            weights[i] = inputIntInRange(message, 45, 120);
        }
        return weights;
    }
}
