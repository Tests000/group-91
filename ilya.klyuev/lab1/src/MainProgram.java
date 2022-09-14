public class MainProgram {
    public static void main(final String[] args) {
        int[] temperatures = inputTemperatures();
        int[] answer = findHighestTemperatureForEachDay(temperatures);

        System.out.print("Ответ: ");
        for (int item : answer
        ) {
            System.out.printf("%d ", item);
        }
    }

    private static int[] inputTemperatures() {
        CorrectInput correctInput = new CorrectInput();
        int temperaturesNumber = correctInput
                .InputIntInRange("Введите количество дней", 1, 105);
        int[] temperatures = new int[temperaturesNumber];

        for (int i = 0; i < temperaturesNumber; i++) {
            String message = String.format("Введите температуру за %d день", i + 1);
            temperatures[i] = correctInput.InputIntInRange(message, 30, 100);
        }
        return temperatures;
    }

    private static int[] findHighestTemperatureForEachDay(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int firstMoreTemperatureIndex = findFirstMoreTemperature(temperatures, i);
            answer[i] = (firstMoreTemperatureIndex == -1 ? 0 :
                    firstMoreTemperatureIndex - i);
        }

        return answer;
    }

    private static int findFirstMoreTemperature(int[] temperatures, int startIndex) {
        for (int i = startIndex + 1; i < temperatures.length; i++)
            if (temperatures[i] > temperatures[startIndex])
                return i;
        return -1;
    }
}
