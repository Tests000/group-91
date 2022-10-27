import java.util.*;

public final class VotesGenerator {

    private final int voterCount;
    private final int candidateCount;

    public VotesGenerator(int voterCount, int candidateCount) {
        this.voterCount = voterCount;
        this.candidateCount = candidateCount;
    }

    public Collection<Integer> generateWithPriorityQueue() {
        return generate(new PriorityQueue<>());
    }

    public Collection<Integer> generateWithArrayDeque() {
        return generate(new ArrayDeque<>());
    }

    public Collection<Integer> generateWithArrayList() {
        return generate(new ArrayList<>());
    }

    public Collection<Integer> generateWithLinkedList() {
        return generate(new LinkedList<>());
    }

    private Collection<Integer> generate(Collection<Integer> rawVotes) {

        Random random = new Random();

        for (int i = 0; i < voterCount; i++) {
            rawVotes.add(random.nextInt(1, candidateCount + 1));
        }

        return rawVotes;
    }
}