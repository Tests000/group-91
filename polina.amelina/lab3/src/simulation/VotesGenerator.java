package simulation;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class VotesGenerator {

    private final int voterCount;
    private final int candidateCount;

    public VotesGenerator(int voterCount, int candidateCount) {
        this.voterCount = voterCount;
        this.candidateCount = candidateCount;
    }

    public void generateToCollection(Collection<Integer> rawVotes) {

        Random random = new Random();

        for (int i = 0; i < voterCount; i++) {
            rawVotes.add(random.nextInt(1, candidateCount + 1));
        }
    }

    public void generateToInputStream() throws IOException {

        Random random = new Random();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < voterCount; i++) {
            stringBuilder.append(random.nextInt(1, candidateCount + 1)).append(" ");
        }

        try (InputStream inputStream = new ByteArrayInputStream(stringBuilder.toString().getBytes(StandardCharsets.UTF_8))) {
            System.setIn(inputStream);
        } catch (IOException e) {
            Logger.getGlobal().log(Level.SEVERE, "ошибка при записи случайных чисел в поток ввода", e);
            throw e;
        }
    }
}