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
    public static void main(String[] args) {
        int candidateForHappyNumber;
        boolean happyNumber = true;

        System.out.print("Введите число  от 1 до 2 ^ 31 - 1: ");
        boolean correctInput = true;
        Scanner scan = new Scanner(System.in);

        do {
            candidateForHappyNumber = scan.nextInt();

            if (candidateForHappyNumber < 1 || candidateForHappyNumber > (Math.pow(2,31) - 1)) {
                correctInput = false;
                System.out.print("Ошибка ввода. Введите число от 1 до 2 ^ 31 - 1: ");
            }
            else {
                correctInput = true;
            }
        } while(!correctInput);

        int sum = 0;
        int lengthCandidate;
        boolean exitTheLoop = false;
        do {
            lengthCandidate = String.valueOf(candidateForHappyNumber).length();

            if (lengthCandidate == 1 && candidateForHappyNumber != 1) {
                happyNumber = false;
                exitTheLoop = true;
            }
            else {
                int[] arrayNumbers;
                arrayNumbers = new int[lengthCandidate];
                for (int i = lengthCandidate - 1; i > -1; i--) {
                    arrayNumbers[i] = candidateForHappyNumber % 10;
                    candidateForHappyNumber /= 10;
                }

                for (int i = 0; i < lengthCandidate; i++) {
                    sum += Math.pow(arrayNumbers[i], 2);
                }

                if(sum == 1) {
                    happyNumber = true;
                    exitTheLoop = true;
                }
                else {
                    candidateForHappyNumber = sum;
                    sum = 0;
                }
            }
        } while(!exitTheLoop);

        System.out.println("Является ли введенное число счастливым: " + happyNumber);
    }
}