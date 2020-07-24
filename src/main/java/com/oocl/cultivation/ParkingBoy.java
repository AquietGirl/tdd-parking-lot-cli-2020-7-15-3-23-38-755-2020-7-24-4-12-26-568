package com.oocl.cultivation;

import java.awt.font.TextHitInfo;
import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    private List<Ticket> ticketList;

    public ParkingBoy() {
        ticketList = new ArrayList<>();
    }

    public Ticket parkingCar(Car car) {
        Ticket ticket = new Ticket(car.getCarNumber(), car);
        ticketList.add(ticket);
        return ticket;
    }

    public Car fetchingCar(Ticket ticket) {
        if (isInvalidTicket(ticket)) {
            return null;
        }
        return new Car("car1");
    }

    private boolean isInvalidTicket(Ticket ticket) {
        if (isNoTicket(ticket)){
            return true;
        }
        if (isWrongTicket(ticket)) {
            return true;
        }
        return false;
    }

    private boolean isNoTicket(Ticket ticket){
        return ticket == null;
    }

    private boolean isWrongTicket(Ticket ticket) {
        for (Ticket ticketEach: ticketList){
            if (ticketEach.getTicketNumber() == ticket.getTicketNumber()){
                return false;
            }
        }
        return true;
    }
}
