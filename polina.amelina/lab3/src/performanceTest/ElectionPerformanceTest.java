package performanceTest;

import simulation.Election;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ElectionPerformanceTest extends AbstractPerformanceTest {

    private ElectionPerformanceTest() {}

    public static List<Integer> chooseCollection(Election election) {

        System.out.printf("--------%n%s: тестируем каждую коллекцию %s раз%n", Election.class, BENCHMARK_SIZE);

        long arrayListPerformance = testArrayList(election);
        System.out.printf("%s: %s ms%n", ArrayList.class, arrayListPerformance);

        long linkedListPerformance = testLinkedList(election);
        System.out.printf("%s: %s ms%n", LinkedList.class, linkedListPerformance);

        List<Integer> list = arrayListPerformance < linkedListPerformance ?
                new ArrayList<>() :
                new LinkedList<>();
        System.out.printf("Выбираем %s%n", list.getClass());
        return list;
    }

    private static long testArrayList(Election election) {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < BENCHMARK_SIZE; i++) {
            election.countVotes(new ArrayList<>());
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long testLinkedList(Election election) {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < BENCHMARK_SIZE; i++) {
            election.countVotes(new LinkedList<>());
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}