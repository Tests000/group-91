package classes;

public class Bus {
    public String busName;
    private int dayCash;

    public Bus(String busName) {
        this.busName = busName;
        this.setCash(0);
    }

    public void setCash(int cash) {
        dayCash = cash;
    }

    public int dayEnds() {
        return dayCash;
    }
}
