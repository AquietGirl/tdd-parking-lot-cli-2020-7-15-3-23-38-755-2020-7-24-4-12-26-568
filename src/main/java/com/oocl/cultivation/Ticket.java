package com.oocl.cultivation;


public class Ticket {
    private Car car;
    private String ticketNumber;

    public Ticket(String ticketNumber, Car car) {
        this.ticketNumber = ticketNumber;
        this.car = car;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public Car getCar() {
        return car;
    }


}
