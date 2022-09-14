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
0 <= arr[i] <= 10^4*/
public class Program {

    public static void main(String[] args) {
        int[] arr = [3, 4, 5, 3, 2, 1, 9, 0];
        validMountainArray();
        System.out.println("Hello world!");
        System.out.println("Bye world...");
    }
    public boolean validMountainArray(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int n = arr.length - 1;
        while (i + 1 < n && arr[i] < arr[i+1]) {
            i++;
        }

        while (j > 0 && arr[j] < arr[j-1]) {
            j--;
        }

        return (i > 0 && i == j && j < n);
    }
}
