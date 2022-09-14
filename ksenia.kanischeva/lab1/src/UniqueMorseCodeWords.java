import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    private static final String[] COODES = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.",
            "---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."} ;

    private String[] transform(String[] words){
        if (words.length == 0){
            return null;
        }


        String[] transformedWords = new String[words.length];

        for (int i = 0; i < words.length; i++){
            String word = words[i];
            StringBuilder transformedWord = new StringBuilder();
            for (int j = 0; j < word.length(); j++){
                transformedWord.append(COODES[word.charAt(j) - 'a']);
            }
            transformedWords[i] = transformedWord.toString();
        }

        return transformedWords;
    }

    private int countUnigueCodes(String[] transformedWords){
        if (transformedWords == null){
            return 0;
        }

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(transformedWords));
        return uniqueWords.size();
    }

//    public int countUniqueWords(String){
//        return countUnigueCodes(transform())
//
//    }

}
