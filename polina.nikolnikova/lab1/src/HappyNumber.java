/*

Happy Number

Напишите алгоритм, определяющий, является ли число n счастливым.

Счастливое число — это число, определяемое следующим процессом:
Замените число суммой квадратов его цифр.
Повторяйте процесс до тех пор, пока число не станет равным 1,
или пока результат не будет бесконечно повторяться в цикле (который не включает 1).
Те числа, для которых этот процесс заканчивается единицей, счастливые.

Верните true, если n — счастливое число, и false, если нет.

Пример 1:

Input: n = 19
Output: true
Объяснение:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

Пример 2:

Input: n = 2
Output: false

Ограничения:

1 <= n <= 2^31 - 1
*/

import java.util.Scanner;

public class HappyNumber {

    public static boolean isAlphaNumeric(String stringInput) {
        return stringInput != null && stringInput.matches("^[0-9]*$");
    }

    public static int candidateInput() {
        Scanner scan = new Scanner(System.in);
        String candidate = scan.nextLine();

        if (isAlphaNumeric(candidate)) {
            int candidateForHappyNumber = Integer.parseInt(candidate);

            if (candidateForHappyNumber > 0 && candidateForHappyNumber < Math.pow(2, 31)) {
                return candidateForHappyNumber;
            }
        }
        return -1;
    }

    public static void convertingNumberToArray(int[] arrayNumbers, int lengthCandidate, int candidateForHappyNumber) {
        for (int i = lengthCandidate - 1; i > -1; i--) {
            arrayNumbers[i] = candidateForHappyNumber % 10;
            candidateForHappyNumber /= 10;
        }
    }

    public static int countingNonZeroDigints(int[] arrayNumbers, int lengthCandidate) {
        int counterOfNonZeroDigits = 0;
        for (int i = 0; i < lengthCandidate; i++) {
            if (arrayNumbers[i] != 0) {
                counterOfNonZeroDigits++;
            }
        }
        return counterOfNonZeroDigits;
    }

    public static int calculatingTheAmount(int[] arrayNumbers, int lengthCandidate, int counterOfNonZeroDigits) {
        int sum = 0;
        if (counterOfNonZeroDigits == 1 && arrayNumbers[0] != 1 && arrayNumbers[0] != 7) {
            return -1;
        }

        for (int i = 0; i < lengthCandidate; i++) {
            sum += Math.pow(arrayNumbers[i], 2);
        }

        return sum;
    }

    public static void main(String[] args) {
        boolean happyNumber = true;

        System.out.print("Введите число  от 1 до 2 ^ 31 - 1: ");
        int candidateForHappyNumber;

        do {
            candidateForHappyNumber = candidateInput();
            if (candidateForHappyNumber == -1) {
                System.out.print("Ошибка ввода. Введите число от 1 до 2 ^ 31 - 1: ");
            }
        } while (candidateForHappyNumber == -1);

        int lengthCandidate;
        boolean exitTheLoop = false;
        do {
            lengthCandidate = String.valueOf(candidateForHappyNumber).length();

            int[] arrayNumbers;
            arrayNumbers = new int[lengthCandidate];
            convertingNumberToArray(arrayNumbers, lengthCandidate, candidateForHappyNumber);
            int counterOfNonZeroDigits = countingNonZeroDigints(arrayNumbers, lengthCandidate);
            int sum = calculatingTheAmount(arrayNumbers, lengthCandidate, counterOfNonZeroDigits);
            if (sum == -1) {
                happyNumber = false;
                exitTheLoop = true;
            } else if (sum == 1) {
                exitTheLoop = true;
            } else {
                candidateForHappyNumber = sum;
            }
        } while (!exitTheLoop);

        System.out.println("Является ли введенное число счастливым: " + happyNumber);
    }
}