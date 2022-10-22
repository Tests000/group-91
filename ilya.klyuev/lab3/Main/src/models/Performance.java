package models;

import factories.ListFactory;

import java.util.List;

public class Performance {
    private int ticketsCount = 0;
    private final String name;

    public Performance(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addTicket(){
        ticketsCount++;
    }

    public int getTicketsCount(){
        return ticketsCount;
    }

    public static List<Performance> getPerformancesByCount(int performancesCount){
        if (performancesCount < 0)
            return null;

        List<Performance> performanceList = ListFactory.createList();

        for (int i = 1; i <= performancesCount; i++){
            performanceList.add(new Performance(String.format("Спектакль%d", i)));
        }

        return performanceList;
    }
}
