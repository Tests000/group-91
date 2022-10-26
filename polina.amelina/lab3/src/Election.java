import java.util.*;

public final class Election {
    private final Collection<Integer> rawVotes;
    private final int candidateCount;
    private final int minVoterPercent;

    public Election(Collection<Integer> rawVotes, int candidateCount, int minVoterPercent) {
        this.rawVotes = rawVotes;
        this.candidateCount = candidateCount;
        this.minVoterPercent = minVoterPercent;
    }

    public int countVotesWithArrayList() {
        return countVotes(new ArrayList<>());
    }

    public int countVotesWithLinkedList() {
        return countVotes(new LinkedList<>());
    }

    public int countVotesWithVector() {
        return countVotes(new Vector<>());
    }

    private int countVotes(List<Integer> countedVotes) {

        for (int i = 0; i < candidateCount; i++) {
            countedVotes.add(0);
        }

        for (int candidate : rawVotes) {
            countedVotes.set(candidate - 1, countedVotes.get(candidate - 1) + 1);
        }

        boolean isTie = false;
        int candidateWithMaxVotes = 0;

        for (int i = 1; i < candidateCount; i++) {

            int maxVotes = countedVotes.get(candidateWithMaxVotes);
            int currentVotes = countedVotes.get(i);

            if (maxVotes == currentVotes) {
                isTie = true;
                continue;
            }

            if (maxVotes < currentVotes) {
                isTie = false;
                candidateWithMaxVotes = i;
            }
        }

        boolean doesCandidateQualify = !isTie && countedVotes.get(candidateWithMaxVotes) >= rawVotes.size() / 100.0 * minVoterPercent;
        return doesCandidateQualify ? candidateWithMaxVotes + 1 : 0;
    }
}