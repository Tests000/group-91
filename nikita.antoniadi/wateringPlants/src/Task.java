import javax.swing.*;
import java.util.Scanner;

public class Task {
    public static int solution() {
        int capacity = getCapacity(), amount = getPlantsAmount();
        int[] plants = getWaterNeeded(amount, capacity);
        int steps = 0, waterInWateringCan = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (waterInWateringCan >= plants[i]) {
                waterInWateringCan -= plants[i];
                steps++;
            }
            else {
                steps += 2 * i + 1;
                waterInWateringCan = capacity - plants[i];
            }
        }
        return steps;
    }

    private static int getCapacity() {
        System.out.println("Введите объем лейки");
        return getInt();
    }

    private static int getInt() {
        int num;
        Scanner scan = new Scanner(System.in);
        num = scan.nextInt();
        return num;
    }

    private static int getPlantsAmount() {
        System.out.println("Введите количество цветов");
        return getInt();
    }

    private static int[] getWaterNeeded(int amount, int capacity) {
        int[] plants = new int[amount];
        int i = 0;
        while (i < amount) {
            System.out.println("Введите количество воды для полива " + Integer.toString(i + 1) + "-го цветка");
            plants[i] = getInt();
            if (plants[i] <= capacity)
                i++;
            else
                System.out.println("В лейке нет столько воды!");
        }
        return plants;
    }
}
