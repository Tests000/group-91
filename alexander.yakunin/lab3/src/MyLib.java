import java.util.List;

public class MyLib {
    public static int getRandomNumber(int border) {
        return (int) (Math.random() * border);
    }
    public static int getMaxValue(List<Integer> list) {
        int max = list.get(0);
        for (Integer elem: list) {
            if (elem > max) max = elem;
        }

        return max;
    }
}

