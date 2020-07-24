package com.oocl.cultivation;

import java.util.Objects;

public class Ticket {
    private int ticketNumber;
    public Ticket(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return ticketNumber == ticket.ticketNumber;
    }
}
