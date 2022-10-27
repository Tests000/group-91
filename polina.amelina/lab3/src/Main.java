import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Scanner;

public final class Main {
    private static final int CANDIDATE_COUNT = 12;
    private static final int MIN_VOTER_PERCENT = 10;
    private static final int VOTER_COUNT = 300;

    public static void main(String[] args) {

        Collection<Integer> rawVotes = votesGeneratorOutput();

        StringBuilder stringBuilder = new StringBuilder();
        for (int vote : rawVotes) {
            stringBuilder.append(vote).append(" ");
        }

        try (InputStream inputStream = new ByteArrayInputStream(stringBuilder.toString().getBytes(StandardCharsets.UTF_8))) {
            System.setIn(inputStream);
        } catch (IOException ignored) {}

        rawVotes.clear();

        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextInt()) {
                rawVotes.add(scanner.nextInt());
            }
        }

        electionOutput(rawVotes);
    }

    private static Collection<Integer> votesGeneratorOutput() {

        VotesGenerator votesGenerator = new VotesGenerator(VOTER_COUNT, CANDIDATE_COUNT);

        System.out.printf("Сколько миллисекунд займет генерация голосов каждым методом %s раз?%n", PerformanceTest.BENCHMARK_SIZE);

        long arrayListPerformance = PerformanceTest.testVotesGeneratorArrayList(votesGenerator);
        System.out.printf("Array List: %s ms%n", arrayListPerformance);

        long linkedListPerformance = PerformanceTest.testVotesGeneratorLinkedList(votesGenerator);
        System.out.printf("Linked List: %s ms%n", linkedListPerformance);

        long priorityQueuePerformance = PerformanceTest.testVotesGeneratorPriorityQueue(votesGenerator);
        System.out.printf("Priority Queue: %s ms%n", priorityQueuePerformance);

        long arrayDequePerformance = PerformanceTest.testVotesGeneratorArrayDeque(votesGenerator);
        System.out.printf("Array Deque: %s ms%n", arrayDequePerformance);

        return arrayListPerformance < linkedListPerformance ?
                arrayListPerformance < priorityQueuePerformance ?
                        arrayListPerformance < arrayDequePerformance ?
                                votesGenerator.generateWithArrayList() :
                                votesGenerator.generateWithArrayDeque() :
                        priorityQueuePerformance < arrayDequePerformance ?
                                votesGenerator.generateWithPriorityQueue() :
                                votesGenerator.generateWithArrayDeque() :
                linkedListPerformance < priorityQueuePerformance ?
                        linkedListPerformance < arrayDequePerformance ?
                                votesGenerator.generateWithLinkedList() :
                                votesGenerator.generateWithArrayDeque() :
                        priorityQueuePerformance < arrayDequePerformance ?
                                votesGenerator.generateWithPriorityQueue() :
                                votesGenerator.generateWithArrayDeque();
    }

    private static void electionOutput(Collection<Integer> rawVotes) {

        Election election = new Election(rawVotes, CANDIDATE_COUNT, MIN_VOTER_PERCENT);

        System.out.printf("Сколько миллисекунд займет нахождение кандидата каждым методом %s раз?%n", PerformanceTest.BENCHMARK_SIZE);

        long arrayListPerformance = PerformanceTest.testElectionArrayList(election);
        System.out.printf("Array List: %s ms%n", arrayListPerformance);

        long linkedListPerformance = PerformanceTest.testElectionLinkedList(election);
        System.out.printf("Linked List: %s ms%n", linkedListPerformance);

        int candidate = arrayListPerformance < linkedListPerformance ?
                election.countVotesWithArrayList() :
                election.countVotesWithLinkedList();

        System.out.printf(candidate == 0 ?
                "Не удалось выбрать представителя%n" :
                "Выбрали представителя %s%n", candidate);
    }
}