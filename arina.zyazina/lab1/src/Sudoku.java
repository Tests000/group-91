import java.util.InputMismatchException;
import java.util.Scanner;

public class Sudoku {
    static private final int MAX_LENGTH = 9;
    static private final int BOX_LENGTH = 3;
    static private final String CORRECT_SYMBOLS = "123456789.";

    private final int[][] sudokuBoard;

    public Sudoku(char[][] inputArr) {
        sudokuBoard = new int[MAX_LENGTH][MAX_LENGTH];
        for (int i = 0; i < MAX_LENGTH; i++) {
            for (int j = 0; j < MAX_LENGTH; j++) {
                if (inputArr[i][j] == '.') {
                    sudokuBoard[i][j] = 0;
                } else {
                    sudokuBoard[i][j] = inputArr[i][j] - '0';
                    if (!isValid(i, j, sudokuBoard[i][j])) {
                        throw new InputMismatchException();
                    }
                }
            }
        }
    }

    public static Sudoku getSudoku() {
        char[][] inputArr = Sudoku.inputBoard();
        return new Sudoku(inputArr);
    }

    private static char[][] inputBoard() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите частично заполненное судоку");
        System.out.println("Судоку состоит из 9 строк, каждая строка содержит 9 символов, символы разделяются одним пробелом");
        System.out.println("Допускаемые символы: цифры от 1 до 9 и '.'");
        String bufString;
        char[][] resultBoard = new char[MAX_LENGTH][MAX_LENGTH];
        for (int i = 0; i < MAX_LENGTH; i++) {
            bufString = sc.nextLine();
            while (!isCorrectLine(bufString)) {
                System.out.println("Была введена некорректная строка, пожалуйста, повторите ввод");
                bufString = sc.nextLine();
            }
            for (int j = 0; j < 2 * MAX_LENGTH - 1; j += 2) {
                resultBoard[i][j / 2] = bufString.charAt(j);
            }
        }
        return resultBoard;
    }

    private static boolean isCorrectLine(String line) {
        int correctLength = 2 * MAX_LENGTH - 1;
        if (line.length() != correctLength) {
            return false;
        }
        for (int i = 0; i < correctLength; i += 2) {
            if (!CORRECT_SYMBOLS.contains(String.valueOf(line.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        for (int i = 0; i < MAX_LENGTH; i++) {
            for (int j = 0; j < MAX_LENGTH; j++) {
                System.out.print(sudokuBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean solve() {
        return solve(0, 0);
    }

    private boolean solve(int curRow, int curCol) {
        if (curRow == MAX_LENGTH) {
            return true;
        }
        if (curCol == MAX_LENGTH) {
            return solve(curRow + 1, 0);
        }
        if (sudokuBoard[curRow][curCol] != 0) {
            return solve(curRow, curCol + 1);
        }
        for (int i = 1; i <= MAX_LENGTH; i++) {
            if (isValid(curRow, curCol, i)) {
                sudokuBoard[curRow][curCol] = i;
                if (solve(curRow, curCol + 1)) {
                    return true;
                }
                sudokuBoard[curRow][curCol] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int curRow, int curCol, int num) {
        boolean notInColumn = true;
        for (int i = 0; i < MAX_LENGTH && notInColumn; i++) {
            notInColumn = num != sudokuBoard[i][curCol];
        }

        boolean notInRow = true;
        for (int j = 0; j < MAX_LENGTH && notInRow; j++) {
            notInRow = num != sudokuBoard[curRow][j];
        }

        boolean notInBox = true;
        int curBoxRow = curRow / BOX_LENGTH * BOX_LENGTH;
        int curBoxColumn = curCol / BOX_LENGTH * BOX_LENGTH;
        for (int i = curBoxRow; i < curBoxRow + BOX_LENGTH && notInBox; i++) {
            for (int j = curBoxColumn; j < curBoxColumn + 3 && notInBox; j++) {
                notInBox = num != sudokuBoard[i][j];
            }
        }

        return notInColumn && notInRow && notInBox;
    }
}