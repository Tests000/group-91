import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class UniqueMorseCodeWords {
    private static final String[] COODES = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    private String[] transform(String[] words) throws Exception {
        String[] transformedWords = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder transformedWord = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                int position = word.charAt(j) - 'a';
                if (position < 0 || position >= COODES.length) {
                    throw new Exception("Incorrect word format " + word);
                }
                transformedWord.append(COODES[position]);
            }
            transformedWords[i] = transformedWord.toString();
        }

        return transformedWords;
    }

    private int countUniqueCodes(String[] transformedWords) {
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(transformedWords));
        return uniqueWords.size();
    }

    public int getCountUniqueWords(String line) throws Exception {
        String[] words = line.split(", ");
        if (isCorrect(words)) {
            return countUniqueCodes(transform(words));
        }
        return 0;
    }

    private boolean isCorrect(String[] words) throws Exception {
        if (words.length == 0 || words.length > 100) {
            throw new Exception("Incorrect number of words");
        }

        final Stream<String> longWords = Arrays.stream(words).filter(word -> word.length() == 0 || word.length() > 12);

        if (longWords.count() > 0) {
            throw new Exception("Incorrect length of words " + longWords);
        }

        return true;
    }

}
