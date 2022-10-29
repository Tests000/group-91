import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InputData {
    static private final int COUNT_OF_STUDENTS = 10000;
    static public int countOfShows = 10;
    static public boolean isArrayList = true;

    static private int getCountOfSelectedShows() {
        return MyLib.getRandomNumber(countOfShows - 1) + 1;
    }

    static private List<Integer> getListOfStudentTickets()  {
        int countOfSelectedShows = getCountOfSelectedShows();
        List<Integer> showTickets = isArrayList ? new ArrayList<>() : new LinkedList<>();

        for(int i = 0; i < countOfSelectedShows; ++i) {
            showTickets.add(MyLib.getRandomNumber(countOfShows));
        }

        return showTickets;
    }

    static public List<Integer> getInputData() {
        List<Integer> data = isArrayList ? new ArrayList<>() : new LinkedList<>();

        for (int i = 0; i < COUNT_OF_STUDENTS; ++i) {
            data.addAll(getListOfStudentTickets());
        }
        return data;
    }
}
