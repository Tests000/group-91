public class Main {
    public static void main(String[] args) {
        int[][] grid = {{4, 3, 8, 4},
                        {9, 5, 1, 9},
                        {2, 7, 6, 2}};

        System.out.println("Output: " + NumMagicSquaresInside(grid));
    }

    public static int NumMagicSquaresInside(int[][] grid) {
        int numRow = grid.length, numCol = grid[0].length, result = 0;
        for (int i = 0; i < numRow - 2; i++) {
            for (int j = 0; j < numCol - 2; j++) {
                if (IsMagic(grid, i, j))
                    result++;
            }
        }

        return result;
    }

    private static boolean IsMagic(int[][] grid, int row, int col) {
        int[] record = new int[10];
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (grid[i][j] < 1 || grid[i][j] > 9 || record[grid[i][j]] > 0) {
                    return false;
                }
                record[grid[i][j]] = 1;
            }
        }
        int mainDiagonal = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int sideDiagonal = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];
        if (mainDiagonal != sideDiagonal) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            if (grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2] != mainDiagonal) {
                return false;
            }
            if (grid[row][col + i] + grid[row + 1][col + i] + grid[row + 2][col + i] != mainDiagonal) {
                return false;
            }
        }

        return true;
    }
}