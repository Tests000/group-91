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
        int boatsMax = correctInput.inputIntInRange("Введите максимальный вес, который может перевезти каждая лодка",
                130, 300);

        int result = boatsToSave.task(boatsMax, weights);
        System.out.print("Минимально для спасения требуется " + result + " лодок.");
    }
}