import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*Number of Burgers with No Waste of Ingredients

        Даны два целых числа tomatoSlices и cheeseSlices. Ингредиенты для разных бургеров следующие:

        Бигтейсти: 4 ломтика помидора и 1 ломтик сыра.
        Джуниор: 2 ломтика помидора и 1 ломтик сыра.
        Верните [количество_бигтейсти, количество_джуниор] чтобы количество оставшихся слайсов было равно 0.
        Если это невозможно, верните [].

        Пример 1:

        Input: tomatoSlices = 16, cheeseSlices = 7
        Output: [1,6]
        Объяснение: для 1 бигтейсти и 6 джуниор 4*1 + 2*6 = 16 кусочков помидоров and 1 + 6 = 7 сыра.

        Пример 2:

        Input: tomatoSlices = 17, cheeseSlices = 4
        Output: []
        Объяснение: Невозможно использовать все ингредиенты для приготовления бургеров.

        Пример 3:

        Input: tomatoSlices = 4, cheeseSlices = 17
        Output: []
        Объяснение: После приготовления 1 бигтейсти останется 16 кусочков сыра, а после приготовления 2 small burger останется 15 кусочков сыра.


        Ограничения:

        0 <= tomatoSlices, cheeseSlices <= 107
*/
public class Burgers {
    /*  Кол-во кусочков томата = 4 * кол-во БТ + 2 * кол-во Дж  (1)
        Кол-во кусочков сыра = кол-во БТ + кол-во Дж             (2)

        Решение задачи состоит в проверки математических условий.
        Совершим преобразования, с помощью которых выразим кол-во бургеров.

        (1) - 2 * (2) => Т - 2 * С = 4*БТ + 2*Дж - 2*БТ - 2*Дж => Т - 2*С = 2*БТ => БТ = Т/2 - С
        (1) - 4 * (2) => Т - 4 * С = 4*БТ + 2*Дж - 4*БТ - 4*Дж => Т - 4*С = -2*Дж => Дж = 2С - Т/2

        БТ = Т/2 - С
        Дж = 2С - Т/2

        Если эти числа подходят под возможное кол-во бургеров (>=0 и целые), то все корректно, иначе задача не решается.
     */

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> answer = new ArrayList<>();

        double numberOfBT = (double) tomatoSlices / 2 - cheeseSlices;
        double numberOfJun = 2 * cheeseSlices - (double) tomatoSlices / 2;

        if (numberOfBT < 0 || numberOfJun < 0) {
            return answer;
        }

        if (numberOfBT != (int) numberOfBT || numberOfJun != (int) numberOfJun) {
            return answer;
        } else {
            answer.add((int) numberOfBT);
            answer.add((int) numberOfJun);
            return answer;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tomatoSlices = -1, cheeseSlices = -1;
        do {
            System.out.print("Input amount of tomatoSlices: ");
            while (!in.hasNextInt()) {
                System.out.println("Inappropriate amount of tomatoSlices  ");
                System.out.println("Try one more time please: ");
                in.next();
            }
            tomatoSlices = in.nextInt();
        } while (tomatoSlices < 0 || tomatoSlices > 107);

        do {
            System.out.print("Input amount of cheeseSlices: ");
            while (!in.hasNextInt()) {
                System.out.println("Inappropriate amount of cheeseSlices  ");
                System.out.println("Try one more time please: ");
                in.next();
            }
            cheeseSlices = in.nextInt();
        } while (cheeseSlices < 0 || cheeseSlices > 107);
        Burgers burgers = new Burgers();
        List<Integer> answer = burgers.numOfBurgers(tomatoSlices, cheeseSlices);
        System.out.println(answer);


    }


}
