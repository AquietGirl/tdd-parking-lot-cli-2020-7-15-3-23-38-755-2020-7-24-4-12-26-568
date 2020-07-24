package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParkingBoy {

    private List<Ticket> ticketList;
    private Park park;

    public ParkingBoy() {
        ticketList = new ArrayList<>();
        park = new Park();
    }

    public Park getPark() {
        return park;
    }

    public Ticket parkingCar(Car car) {
        if (park.getEmptyPositionCount() == 0){
            return null;
        }
        Ticket ticket = new Ticket(car.getCarNumber(), car);
        ticketList.add(ticket);
        park.setEmptyPositionCount(park.getEmptyPositionCount() - 1);
        return ticket;
    }

    public Car fetchingCar(Ticket ticket) {
        if (isInvalidTicket(ticket)) {
            return null;
        }
        Iterator<Ticket> ticketIterator = ticketList.iterator();
        while (ticketIterator.hasNext()) {
            Ticket ticketIt = ticketIterator.next();
            if (ticketIt.getTicketNumber() == ticket.getTicketNumber()) {
                ticketIterator.remove();
            }
        }
        park.setEmptyPositionCount(park.getEmptyPositionCount() + 1);
        return ticket.getCar();
    }

    private boolean isInvalidTicket(Ticket ticket) {
        if (isNoTicket(ticket)) {
            return true;
        }
        if (isWrongTicket(ticket)) {
            return true;
        }
        if (isUsedTicket(ticket)) {
            return true;
        }
        return false;
    }

    private boolean isNoTicket(Ticket ticket) {
        return ticket == null;
    }

    private boolean isWrongTicket(Ticket ticket) {
        for (Ticket ticketEach : ticketList) {
            if (ticketEach.getTicketNumber() == ticket.getTicketNumber()) {
                return false;
            }
        }
        return true;
    }

    private boolean isUsedTicket(Ticket ticket) {
        for (Ticket ticketEach : ticketList) {
            if (ticket.getTicketNumber() == ticket.getTicketNumber()) {
                return false;
            }
        }
        return true;
    }
}
