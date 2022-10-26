import java.util.*;

public class Main {
    public static void main(String[] args) {

        Collection<Integer> rawVotes = new ArrayList<>();

        rawVotes.add(1);
        rawVotes.add(2);
        rawVotes.add(3);
        rawVotes.add(4);
        rawVotes.add(5);
        rawVotes.add(6);
        rawVotes.add(7);
        rawVotes.add(8);
        rawVotes.add(8);
        rawVotes.add(9);
        rawVotes.add(10);

        Election election = new Election(rawVotes, 10, 20);

        System.out.print(election.countVotesWithArrayList());
    }
}