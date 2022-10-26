package factories;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListFactory {
    private ListFactory(){

    }
    private static ListChoice selectedList = ListChoice.ARRAYLIST;

    public static <T> List<T> createList(){
        if (selectedList == ListChoice.LINKEDLIST){
            return new LinkedList<>();
        }
        if (selectedList == ListChoice.VECTOR){
            return new Vector<>();
        }
        return new ArrayList<>();
    }

    public static void selectList(ListChoice listChoice){
        selectedList = listChoice;
    }
}
