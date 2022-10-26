public class Main {
    public static void main(String[] args) {
        int[][] grid = Magic.fillArrayRandomAndPrint();
        System.out.println("Output: " + numMagicSquaresInside(grid));
    }

    public static int numMagicSquaresInside(int[][] grid) {
        int numRow = grid.length;
        int numCol = grid[0].length;
        int result = 0;
        for (int i = 0; i < numRow - 2; i++) {
            for (int j = 0; j < numCol - 2; j++) {
                if (Magic.isMagic(grid, i, j))
                    result++;
            }
        }

        return result;
    }
}