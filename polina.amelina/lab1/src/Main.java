import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] commands = readCommands();
        int[][] obstacles = readObstacles();
        WalkingRobotSimulation walkingRobotSimulation = new WalkingRobotSimulation(commands, obstacles);
        walkingRobotSimulation.makeMoves();
        int[] farthestPoint = walkingRobotSimulation.getFarthestPoint();
        System.out.print(farthestPoint[0] * farthestPoint[0] + farthestPoint[1] * farthestPoint[1]);
    }

    private static int[] readCommands() {

        System.out.print("Введите количество команд: ");
        int commandsLength = 0;
        if (scanner.hasNextInt()) {
            commandsLength = scanner.nextInt();
        }
        scanner.nextLine();

        while (1 > commandsLength || commandsLength > 104) {

            System.out.printf("Количество команд должно быть равно целому числу в диапазоне [1, 104].%nВведите еще раз: ");
            if (scanner.hasNextInt()) {
                commandsLength = scanner.nextInt();
            }
            scanner.nextLine();
        }

        int[] commands = new int[commandsLength];
        for (int i = 0; i < commandsLength; i++) {

            System.out.printf("Введите команду %d: ", i + 1);
            if (scanner.hasNextInt()) {
                commands[i] = scanner.nextInt();
            }
            scanner.nextLine();

            while (-2 > commands[i] || commands[i] > 9 || commands[i] == 0) {

                System.out.printf("Команда должна быть равна -2, -1 или целому числу в диапазоне [1, 9].%nВведите еще раз: ");
                if (scanner.hasNextInt()) {
                    commands[i] = scanner.nextInt();
                }
                scanner.nextLine();
            }
        }

        return commands;
    }

    private static int[][] readObstacles() {

        System.out.print("Введите количество препятствий: ");
        int obstaclesLength = -1;
        if (scanner.hasNextInt()) {
            obstaclesLength = scanner.nextInt();
        }
        scanner.nextLine();

        while (0 > obstaclesLength || obstaclesLength > 104) {

            System.out.printf("Количество препятствий должно быть равно целому числу в диапазоне [0, 104].%nВведите еще раз: ");
            if (scanner.hasNextInt()) {
                obstaclesLength = scanner.nextInt();
            }
            scanner.nextLine();
        }

        int[][] obstacles = new int[obstaclesLength][2];
        for (int i = 0; i < obstaclesLength; i++) {

            System.out.printf("Введите координаты x и y для препятствия %d через пробел: ", i + 1);
            if (scanner.hasNextInt()) {
                obstacles[i][0] = scanner.nextInt();
            }
            if (scanner.hasNextInt()) {
                obstacles[i][1] = scanner.nextInt();
            }
            scanner.nextLine();

            while (-3 * 104 > obstacles[i][0] || obstacles[i][0] > 3 * 104 || -3 * 104 > obstacles[i][1] || obstacles[i][1] > 3 * 104) {

                System.out.printf("Координаты препятствия должны быть равны целым числам в диапазоне [-3 * 104, 3 * 104].%nВведите еще раз: ");
                if (scanner.hasNextInt()) {
                    obstacles[i][0] = scanner.nextInt();
                }
                if (scanner.hasNextInt()) {
                    obstacles[i][1] = scanner.nextInt();
                }
                scanner.nextLine();
            }
        }

        return obstacles;
    }
}