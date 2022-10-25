package repository.getters;

import repository.helper.CheckerData;

import java.util.*;

public abstract class GetterList {
    protected final static int COUNT_PLAYERS = 22;
    protected final static int COUNT_FUNS = 3000;

    protected abstract int nextInt();

    protected abstract void fillList(List<Integer> answers);

    private void survey(Set<Integer> answersOnePerson) {
        int player = nextInt();
        if (CheckerData.isCorrectPlayer(player)) {
            if (answersOnePerson.contains(player)) {
                System.out.println("Игрок вами уже был выбран");
                survey(answersOnePerson);
            }
            answersOnePerson.add(player);
        } else {
            System.out.println("Игрок не найден");
            survey(answersOnePerson);
        }
    }

    private void saveAnswers(Set<Integer> answersOnePerson, List<Integer> answers) {
        for (Integer answer : answersOnePerson) {
            answers.set(answer - 1, answers.get(answer - 1) + 1);
        }
    }


    protected void saveAnswers(List<Integer> answers) {
        Set<Integer> answersOnePerson = new HashSet<>();

        for (int i = 0; i < COUNT_FUNS; i++) {
            while (answersOnePerson.size() != 3) {
                survey(answersOnePerson);
            }
            saveAnswers(answersOnePerson, answers);
            answersOnePerson.clear();
        }
    }

    public List<Integer> createArrayList() {
        List<Integer> answers = new ArrayList<>(Collections.nCopies(COUNT_PLAYERS, 0));
        fillList(answers);
        return answers;
    }


    public List<Integer> createLinkedList() {
        List<Integer> answers = new LinkedList<>(Collections.nCopies(COUNT_PLAYERS, 0));
        fillList(answers);
        return answers;
    }
}
