package main.java.com.swiggy.parking.vo.ticket;

public enum TicketType {

    PREMIUM(1),
    CASUAL(2);

    private int type;
    public int getType() {
        return this.type;
    }

    private TicketType(int type) {
        this.type = type;
    }

}
