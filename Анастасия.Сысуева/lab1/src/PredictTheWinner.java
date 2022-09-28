import java.util.Scanner;

public class PredictTheWinner {

    private static final int MINSIZE_CONST = 1;
    private static final int MAXSIZE_CONST = 20;
    private static final int MINELEM_CONST = 0;
    private static final int MAXELEM_CONST = 107;

    public static void main(String[] args) {
        int[] nums = inputArray();
        printArray(nums);
        System.out.println("\n" + predictTheWinner(nums));
    }

    public static boolean restrictionsChecking(final int minValue, final int maxValue, int inputValue) {
        return (minValue > inputValue && inputValue > maxValue);
    }

    public static int[] inputArray() {
        Scanner input = new Scanner(System.in);
        int size;

        do {
            System.out.println("Введите размер массива (от 1 до 20): ");
            size = input.nextInt(); // TODO: поймать исключение либо проверить ввод
        } while (restrictionsChecking(MINSIZE_CONST, MAXSIZE_CONST, size));

        int[] nums = new int[size];
        System.out.println("Введите " + size + " элемент(а/ов) массива (значения элементов от 0 до 107): ");

        for (int i = 0; i < nums.length; i++) {
            nums[i] = input.nextInt();// TODO: поймать исключение либо проверить ввод
            while (restrictionsChecking(MINELEM_CONST, MAXELEM_CONST, nums[i])) {
                System.out.println("Введите " + (i + 1) + " элемент массива (значения элементов от 0 до 107): ");
                nums[i] = input.nextInt();
            }
        }
        return nums;
    }

    public static void printArray(int[] nums) {
        for (int element : nums) {
            System.out.print(element + " ");
        }
    }

    public static boolean predictTheWinner(int[] nums) {
        return recursionPoints(nums, 0, nums.length - 1) >= 0;
    }

    public static int recursionPoints(int[] nums, int leftBorder, int rightBorder) {
        if (leftBorder == rightBorder) {
            return nums[leftBorder];
        }

        int firstElement = nums[leftBorder] - recursionPoints(nums, leftBorder + 1, rightBorder);
        int lastElement = nums[rightBorder] - recursionPoints(nums, leftBorder, rightBorder - 1);

        return Math.max(firstElement, lastElement);
    }

}
