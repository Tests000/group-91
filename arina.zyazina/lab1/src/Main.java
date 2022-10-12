import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        Sudoku sudoku;

        try {
            sudoku = Sudoku.getSudoku();
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("Было введено невалидное судоку :(");
            return;
        }

        if (!sudoku.solve()) {
            System.out.println("Было введено невалидное судоку :(");
        } else {
            System.out.println("Решение судоку имеет вид:");
            sudoku.print();
        }
    }
}