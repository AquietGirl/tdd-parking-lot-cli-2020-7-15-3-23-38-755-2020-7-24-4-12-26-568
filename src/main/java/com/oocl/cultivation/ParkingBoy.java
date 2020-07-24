package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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
        for (Ticket ticketEach: ticketList) {
            if (ticketEach.getCar()==car){
                return null;
            }
        }
        if(car == null) {
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
        ticketList.removeIf(ticket1 -> ticket1.getTicketNumber().equals(ticket.getTicketNumber()));

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
        return false;
    }

    private boolean isNoTicket(Ticket ticket) {
        return ticket == null;
    }

    private boolean isWrongTicket(Ticket ticket) {
        List<Ticket> tickets = ticketList.stream().filter(ticketEach -> ticketEach.getTicketNumber().equals(ticket.getTicketNumber())).collect(Collectors.toList());
        return tickets.size() == 0;
    }
}
