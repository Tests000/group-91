public final class PerformanceTest {

    private PerformanceTest() {}

    public static final int BENCHMARK_SIZE = 10000000;

    public static long testElectionArrayList(Election election) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < BENCHMARK_SIZE; i++) {
            election.countVotesWithArrayList();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static long testElectionLinkedList(Election election) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < BENCHMARK_SIZE; i++) {
            election.countVotesWithLinkedList();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static long testVotesGeneratorArrayList(VotesGenerator votesGenerator) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < BENCHMARK_SIZE; i++) {
            votesGenerator.generateToArrayList();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static long testVotesGeneratorLinkedList(VotesGenerator votesGenerator) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < BENCHMARK_SIZE; i++) {
            votesGenerator.generateToLinkedList();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static long testVotesGeneratorPriorityQueue(VotesGenerator votesGenerator) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < BENCHMARK_SIZE; i++) {
            votesGenerator.generateToPriorityQueue();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static long testVotesGeneratorArrayDeque(VotesGenerator votesGenerator) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < BENCHMARK_SIZE; i++) {
            votesGenerator.generateToArrayDeque();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}