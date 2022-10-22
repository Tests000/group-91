import java.util.Arrays;

public class boatsToSave {
    public static int task(int maxWeight, int[] weights) {// TODO: 19.10.2022 вынести в отдельный класс
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
        int right = weights.length - 1;
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
