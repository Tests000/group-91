package classes;

import java.util.ArrayList;
import java.util.List;

public class TransportModelArrayList {
    private static final int DAYS_CONST = 7;
    private static final int ROUTE_CONST = 10;
    List<List<Integer>> transportRevenue = new ArrayList<>(DAYS_CONST);

    public TransportModelArrayList (){
        for(int i = 0; i < DAYS_CONST; i++){
            transportRevenue.add(new ArrayList<>());
        }
    }


    public void input(int[][] inputArray){
        for(int i = 0; i < DAYS_CONST; i++){
            for(int j = 0; j < ROUTE_CONST; j++){
                transportRevenue.get(i).add(inputArray[i][j]);
            }
        }
    }

    public ArrayList<Integer> sumWeekRoute() {
        ArrayList<Integer> sumWeek = new ArrayList<>(DAYS_CONST);
        int sumRoute = 0;
        for (int i = 0; i < ROUTE_CONST; i++) {
            for (int j = 0; j < DAYS_CONST; j++) {
                sumRoute += transportRevenue.get(j).get(i);
            }
            sumWeek.add(sumRoute);
            sumRoute = 0;
        }
        return sumWeek;
    }

    public void outputWeek(){
        ArrayList<Integer> sumWeek = sumWeekRoute();
        for(int i = 0; i < ROUTE_CONST; i++){
            System.out.println("Выручка за " + (i+1) + " маршрут: " + sumWeek.get(i));
        }
        System.out.println();
    }

    /*public void output(){
        for(int i = 0; i < DAYS_CONST; i++){
            System.out.println("Выручка за " + (i+1) + " день: ");
            for(int j = 0; j < ROUTE_CONST; j++){
                System.out.println("Выручка " + (j+1) + " маршрута: ");
                System.out.println(transportRevenue.get(i).get(j));
            }
        }
    }*/
}
