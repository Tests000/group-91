//Напишите класс, который принимает с клавиатуры информацию о тех спектаклях, на которые решил приобрести билет каждый
// (подумайте, как можно смоделировать ввод с помощью случайных чисел), и затем выводит на экран следующую информацию:
//  • количество билетов, заказанных на каждый спектакль;
//  • самый популярный спектакль (следует учесть вариант, что может быть несколько таких спектаклей);
//  • спектакль (спектакли), на который решили приобрести билеты

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShowsInformation {
    private int countOfShows;
    private List<Integer> tickets;
    private List<Integer> ticketsCount;
    private List<Integer> popularShows;
    private List<Integer> purchasedTickets;


    private boolean isCachedTicketsCount = false;
    private boolean isCachedPopular = false;
    private boolean isCachePurchased = false;

    public ShowsInformation(List<Integer> tickets) {
        countOfShows = Collections.max(tickets) + 1;
        this.tickets = tickets;
    }

    public void setTickets(List<Integer> tickets) {
        this.tickets = tickets;
        this.countOfShows = Collections.max(tickets) + 1;
        this.isCachedPopular = this.isCachedTicketsCount = this.isCachePurchased = false;
    }

    private void calculateTicketsCount() {
        ticketsCount = new ArrayList<Integer>(Collections.nCopies(countOfShows, 0));

        for (int i = 0; i < tickets.size(); ++i) {
            int index = tickets.get(i);
            ticketsCount.set(index, ticketsCount.get(index) + 1);
        }
    }
    public List<Integer> getAllTicketsCount() {
        if(isCachedTicketsCount) {
            return  ticketsCount;
        }

        ticketsCount = new ArrayList<>(10);
        calculateTicketsCount();
        isCachedTicketsCount = true;
        return ticketsCount;
    }
    private void calculatePopularShows() {
        int max = Collections.max(ticketsCount);
        popularShows = new ArrayList<>(countOfShows);

        for(int i = 0; i < ticketsCount.size(); ++i) {
            if(ticketsCount.get(i) == max) {
                popularShows.add(i);
            }
        }
    }
    public List<Integer> getPopularShows() {
        if(isCachedPopular) {
            return popularShows;
        }

        popularShows = new ArrayList<>();
        isCachedPopular = true;

        if(isCachedTicketsCount) {
            calculatePopularShows();
            return popularShows;
        }

        getAllTicketsCount();
        calculatePopularShows();
        return popularShows;
    }
    private void calculatePurchasedTickets() {
        purchasedTickets = new ArrayList<>(countOfShows);

        for(int i = 0; i < ticketsCount.size(); ++i) {
            if(ticketsCount.get(i) != 0) {
                purchasedTickets.add(i);
            }
        }
    }
    public List<Integer> getPurchasedTickets() {
        if(isCachePurchased) {
            return purchasedTickets;
        }
        if(isCachedTicketsCount) {
            calculatePurchasedTickets();
            return purchasedTickets;
        }

        getAllTicketsCount();
        calculatePurchasedTickets();
        return purchasedTickets;
    }

    public void testMethod() {
        isCachedTicketsCount=false;
        getAllTicketsCount();
        isCachedTicketsCount = isCachePurchased =false;
        getPurchasedTickets();
        isCachedTicketsCount = isCachedPopular = false;
        getPopularShows();
    }

}
