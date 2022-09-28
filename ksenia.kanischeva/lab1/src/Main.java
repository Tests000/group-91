import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String line;
        UniqueMorseCodeWords uniqueMorseCodeWords = new UniqueMorseCodeWords();

        while (true) {
            System.out.print("Input: ");
            line = in.nextLine();
            if (line.equals("")) {
                break;
            }
            System.out.print("Output: ");
            try {
                int count = uniqueMorseCodeWords.getCountUniqueWords(line);
                System.out.println(count);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finishing...");
    }
}
