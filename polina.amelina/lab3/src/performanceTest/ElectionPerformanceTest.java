package performanceTest;

import simulation.Election;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ElectionPerformanceTest extends AbstractPerformanceTest {

    private ElectionPerformanceTest() {}

    public static List<Integer> chooseCollection(Election election) {

        System.out.printf("Сколько миллисекунд займет нахождение кандидата каждым методом %s раз?%n", BENCHMARK_SIZE);

        long arrayListPerformance = testArrayList(election);
        System.out.printf("Array List: %s ms%n", arrayListPerformance);

        long linkedListPerformance = testLinkedList(election);
        System.out.printf("Linked List: %s ms%n", linkedListPerformance);

        return arrayListPerformance < linkedListPerformance ?
                new ArrayList<>() :
                new LinkedList<>();
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