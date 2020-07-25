package com.oocl.cultivation;


public class Ticket {
    private Car car;
    private String ticketNumber;
    private Park park;

    public Ticket(String ticketNumber, Car car, Park park) {
        this.ticketNumber = ticketNumber;
        this.car = car;
        this.park = park;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public Car getCar() {
        return car;
    }

    public Park getPark() {return park;}
}
