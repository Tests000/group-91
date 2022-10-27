public final class PerformanceTest {

    private PerformanceTest() {}

    public static final int BENCHMARK_SIZE = 10000000;

    public static long testArrayList(Election election) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < BENCHMARK_SIZE; i++) {
            election.countVotesWithArrayList();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static long testLinkedList(Election election) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < BENCHMARK_SIZE; i++) {
            election.countVotesWithLinkedList();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static long testVector(Election election) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < BENCHMARK_SIZE; i++) {
            election.countVotesWithVector();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}