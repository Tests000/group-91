/*Longest Mountain in Array
Горный массив:
arr.length >= 3
Существует некоторый индекс i, 0 < i < arr.length - 1 такой что:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1] (./|\.)

Дан целочисленный массив arr, вернуть длину самого длинного подмассива, представляющего собой гору.
Верните 0, если нет ни одного горного подмассива.

Пример 1:
Input: arr = [2,1,4,7,3,2,5]
Output: 5

Пример 2:
Input: arr = [2,2,2]
Output: 0

Ограничения:
1 <= arr.length <= 10^4
1 <= arr[i] <= 10^4*/

import java.util.Scanner;

public class Program {
    final static int MIN_LENGTH = 3, MINSIZE_CONST = 1, MAXSIZE_CONST = 10000;
    public static int findMaxSubarray(int[] arr) {
        int currentLength, currentIndex = 0, maxLength = 0;
        boolean isRightPart, isLeftPart;
        while (currentIndex < arr.length - 1) {
            isRightPart = false;
            isLeftPart = false;
            currentLength = 0;
            while (currentIndex + 1 <= arr.length - 1 && arr[currentIndex] < arr[currentIndex + 1]) {
                currentIndex++;
                currentLength++;
                isLeftPart = true;
            }

            while (currentIndex + 1 <= arr.length - 1 && arr[currentIndex] > arr[currentIndex + 1]) {
                currentIndex++;
                currentLength++;
                isRightPart = true;
            }
            if (isLeftPart && isRightPart && currentLength > maxLength)
                maxLength = currentLength;
        }
        return (maxLength >= 3) ? (maxLength + 1) : 0;
    }

    public static boolean isInRange(int minElem, int maxElem, int number){
        return number >= minElem && number <= maxElem;
    }

    public static int[] inputArray() {
        Scanner in = new Scanner(System.in);
        int size;
        do {
            System.out.println("Введите размер массива (от 1 до 10000): ");
            while (!in.hasNextInt()) {
                System.out.println("Введено не int значение");
                in.next();
            }
            size = in.nextInt();
        } while (!isInRange(MINSIZE_CONST, MAXSIZE_CONST, size));

        int[] nums = new int[size];
        System.out.println("Введите " + size + " элемент(а/ов) массива (значения элементов от 0 до 10000): ");

        for (int i = 0; i < nums.length; i++) {
            while (!in.hasNextInt()) {
                System.out.println("Введено не int значение");
                in.next();
            }
            nums[i] = in.nextInt();

            while (!isInRange(MINSIZE_CONST, MAXSIZE_CONST, nums[i])) {
                System.out.println("Введите " + (i + 1) + " элемент массива (значения элементов от 0 до 10000): ");
                while (!in.hasNextInt()) {
                    System.out.println("Введено не int значение");
                    in.next();
                }
                nums[i] = in.nextInt();
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int arr[] = {10, 1, 2, 3, 2, 8, 9, 11, 12};
        int[] arrayNum = inputArray();

        int res = findMaxSubarray(arrayNum);
        System.out.println("Максимальная длина горного массива:");
        System.out.println(res);
    }
}