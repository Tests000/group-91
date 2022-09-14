public class Task {

    public int[] findHighestTemperatureForEachDay(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int firstMoreTemperatureIndex = findFirstMoreTemperature(temperatures, i);
            answer[i] = (firstMoreTemperatureIndex == -1
                    ? 0
                    : firstMoreTemperatureIndex - i);
        }

        return answer;
    }

    private int findFirstMoreTemperature(int[] temperatures, int startIndex) {
        for (int i = startIndex + 1; i < temperatures.length; i++)
            if (temperatures[i] > temperatures[startIndex])
                return i;
        return -1;
    }
}
