package com.oocl.cultivation;

import java.util.Objects;

public class Ticket {
    private Car car;
    private String ticketNumber;
    public Ticket(String ticketNumber, Car car) {
        this.ticketNumber = ticketNumber;
        this.car = car;
    }

}
