import java.util.*;

public final class Main {
    public static void main(String[] args) {

        int candidateCount = 12;
        int minVoterPercent = 10;
        int voterCount = 300;

        Collection<Integer> rawVotes = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < voterCount; i++) {
            rawVotes.add(random.nextInt(1, candidateCount + 1));
        }

        Election election = new Election(rawVotes, candidateCount, minVoterPercent);

        long arrayListPerformance = PerformanceTest.testArrayList(election);
        System.out.printf("Array List: %s ms%n", arrayListPerformance);

        long linkedListPerformance = PerformanceTest.testLinkedList(election);
        System.out.printf("Linked List: %s ms%n", linkedListPerformance);

        long vectorPerformance = PerformanceTest.testVector(election);
        System.out.printf("Vector: %s ms%n", vectorPerformance);

        System.out.printf("%s%n", arrayListPerformance > linkedListPerformance ?
                arrayListPerformance > vectorPerformance ?
                        election.countVotesWithArrayList() :
                        election.countVotesWithVector() :
                linkedListPerformance > vectorPerformance ?
                        election.countVotesWithArrayList() :
                        election.countVotesWithVector());
    }
}