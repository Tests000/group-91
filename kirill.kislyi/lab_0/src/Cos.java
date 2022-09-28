import java.util.Scanner;

public class Cos{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of iterations for the \"for\" cycle: ");
        int numOfIterations = in.nextInt();
        System.out.println("Enter the measurement error for the \"while\" cycle (0 < eps < 1): ");
        double epsilon = in.nextDouble();
        System.out.println("Enter the variable X: ");
        double x = in.nextDouble();
        System.out.println("The result of calculations for the \"for\" cycle: " + cosinusFor(numOfIterations, x));
        System.out.println("The result of calculations for the \"while\" cycle: " + cosinusWhile(epsilon, x));
    }

    public static double cosinusFor(int iter_, double x_) {
        double result = 1.0;
        double currentAdd = 1.0;
        for (int i = 0; i <= iter_; i++) {
            currentAdd = currentAdd * (-1) * x_ * x_ / ((i * 2 + 1) * (i * 2 + 2));//добиваем ещё по два числа до нужного факториала
            result += currentAdd;
        }

        return result;
    }

    public static double cosinusWhile(double epsilon_, double x_) {
        double result = 1.0;
        double currentAdd = 1.0;
        int i = 0;
        while (Math.abs(currentAdd) > epsilon_) {
            currentAdd = currentAdd * (-1) * x_ * x_ / ((i * 2 + 1) * (i * 2 + 2));//добиваем ещё по два числа до нужного факториала
            result += currentAdd;
            i++;
        }

        return result;
    }
}
