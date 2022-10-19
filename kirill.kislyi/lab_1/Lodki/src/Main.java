//Вам дан массив people, где people[i] — это вес i-го человека, и бесконечное количество лодок,
//каждая из которых может нести максимальный вес.
//Каждая лодка перевозит не более двух человек одновременно, при условии, что сумма весов этих людей не превышает предела.
//
//Верните минимальное количество лодок, чтобы спасти всех людей.

import java.util.Arrays;

public class Main {
    public static void main(final String[] args) {
        CorrectInput correctInput = new CorrectInput();

        int[] weights = correctInput.inputWeights();
        int boatsMax = correctInput.inputIntInRange("Введите максимальный вес, который может перевезти каждая лодка", 130, 300);

        int result = boatsToSave(boatsMax, weights);
        System.out.print("Минимально для спасения требуется " + result + " лодок.");
    }

    public static int boatsToSave(int maxWeight, int[] weights) {
        int result = 0;
        Arrays.sort(weights);
//Алгоритм (чтоб самому не забыть что я тут вообще писал)
// 1) сортируем массив весов людей
// 2) проходим двойным циклом и рассматриваем пары самого тяжелого и легкого человеков
// 3) если они вдвоём влазят в лодку, то увеличиваем результ на 1 и убираем этих двух человек
// 4) если они не влазят, то проблема в толстом. Ему и так дали самого легкого, а они не влазят.
// Сажаем толстого одного, увеличиваем результат на 1. Легкий ещё может с кем-то влезть.
// Продолжаем повторять, пока люди не кончатся.

        int left = 0;
        int right = weights.length -1;
        while (left <= right) {
            if (weights[left] + weights[right] <= maxWeight) {
                left++;
                right--;
            } else {
                right--;
            }

            result++;
        }

        return result;
    }
}