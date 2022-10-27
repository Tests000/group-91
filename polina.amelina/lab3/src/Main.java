import performanceTest.ElectionPerformanceTest;
import performanceTest.VotesGeneratorPerformanceTest;
import simulation.Election;
import simulation.VotesGenerator;

import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

public final class Main {
    private static final int CANDIDATE_COUNT = 12;
    private static final int MIN_VOTER_PERCENT = 10;
    private static final int VOTER_COUNT = 300;

    public static void main(String[] args) {

        VotesGenerator votesGenerator = new VotesGenerator(VOTER_COUNT, CANDIDATE_COUNT);

        try {
            votesGenerator.generateToInputStream();
        } catch (IOException e) {
            return;
        }

        Collection<Integer> rawVotes = VotesGeneratorPerformanceTest.chooseCollection(votesGenerator);

        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextInt()) {
                rawVotes.add(scanner.nextInt());
            }
        }

        System.out.printf("--------%nГолоса:%n");
        StringBuilder stringBuilder = new StringBuilder();
        for (int vote : rawVotes) {
            stringBuilder.append(vote).append(" ");
        }
        System.out.println(stringBuilder);

        Election election = new Election(rawVotes, CANDIDATE_COUNT, MIN_VOTER_PERCENT);
        int candidate = election.countVotes(ElectionPerformanceTest.chooseCollection(election));

        System.out.printf(candidate == 0 ?
                "--------%nНе удалось выбрать представителя%n" :
                "--------%nВыбрали представителя %s%n", candidate);
    }
}