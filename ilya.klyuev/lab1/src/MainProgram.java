public class MainProgram {
    public static void main(final String[] args) {
        CorrectInput correctInput = new CorrectInput();
        Task task = new Task();

        int[] temperatures = correctInput.inputTemperatures();
        int[] answer = task.findHighestTemperatureForEachDay(temperatures);

        System.out.print("Ответ: ");
        for (int item : answer
        ) {
            System.out.printf("%d ", item);
        }
    }
}