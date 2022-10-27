package performanceTest;

import simulation.VotesGenerator;

import java.util.*;

public final class VotesGeneratorPerformanceTest extends AbstractPerformanceTest {

    private VotesGeneratorPerformanceTest() {}

    public static Collection<Integer> chooseCollection(VotesGenerator votesGenerator) {

        System.out.printf("--------%n%s: тестируем каждую коллекцию %s раз%n", VotesGenerator.class, BENCHMARK_SIZE);

        long arrayListPerformance = testArrayList(votesGenerator);
        System.out.printf("%s: %s ms%n", ArrayList.class, arrayListPerformance);

        long linkedListPerformance = testLinkedList(votesGenerator);
        System.out.printf("%s: %s ms%n", LinkedList.class, linkedListPerformance);

        long priorityQueuePerformance = testPriorityQueue(votesGenerator);
        System.out.printf("%s: %s ms%n", PriorityQueue.class, priorityQueuePerformance);

        long arrayDequePerformance = testArrayDeque(votesGenerator);
        System.out.printf("%s: %s ms%n", ArrayDeque.class, arrayDequePerformance);

        Collection<Integer> collection = arrayListPerformance < linkedListPerformance ?
                arrayListPerformance < priorityQueuePerformance ?
                        arrayListPerformance < arrayDequePerformance ?
                                new ArrayList<>() :
                                new ArrayDeque<>() :
                        priorityQueuePerformance < arrayDequePerformance ?
                                new PriorityQueue<>() :
                                new ArrayDeque<>() :
                linkedListPerformance < priorityQueuePerformance ?
                        linkedListPerformance < arrayDequePerformance ?
                                new LinkedList<>() :
                                new ArrayDeque<>() :
                        priorityQueuePerformance < arrayDequePerformance ?
                                new PriorityQueue<>() :
                                new ArrayDeque<>();
        System.out.printf("Выбираем %s%n", collection.getClass());
        return collection;
    }

    private static long testArrayList(VotesGenerator votesGenerator) {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < BENCHMARK_SIZE; i++) {
            votesGenerator.generateToCollection(new ArrayList<>());
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long testLinkedList(VotesGenerator votesGenerator) {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < BENCHMARK_SIZE; i++) {
            votesGenerator.generateToCollection(new LinkedList<>());
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long testPriorityQueue(VotesGenerator votesGenerator) {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < BENCHMARK_SIZE; i++) {
            votesGenerator.generateToCollection(new PriorityQueue<>());
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long testArrayDeque(VotesGenerator votesGenerator) {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < BENCHMARK_SIZE; i++) {
            votesGenerator.generateToCollection(new ArrayDeque<>());
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}