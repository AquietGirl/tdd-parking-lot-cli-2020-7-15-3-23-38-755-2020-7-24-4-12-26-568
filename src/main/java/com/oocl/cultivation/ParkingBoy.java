package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingBoy {

    private List<Ticket> ticketList;
    private Park park;
    private String ticketMessage;
    private String parkMessage;

    public ParkingBoy() {
        ticketList = new ArrayList<>();
        park = new Park();
    }

    public Park getPark() {
        return park;
    }

    public String getTicketMessage() {
        return ticketMessage;
    }

    public String getParkMessage() {
        return parkMessage;
    }

    public Ticket parkingCar(Car car) {
        if (!isCanParkingCar(car)) {
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

    private boolean isCanParkingCar(Car car) {
        if (car == null || isParked(car)) {
            return false;
        }
        if (!hasCarPosition()) {
            return false;
        }
        return true;
    }

    private boolean hasCarPosition() {
        if (park.getEmptyPositionCount() == 0){
            parkMessage = "Not enough position.";
            return false;
        }
        return true;
    }

    private boolean isParked(Car car) {
        List<Ticket> tickets = ticketList.stream().filter(ticket -> ticket.getCar() == car).collect(Collectors.toList());
        return tickets.size() != 0;
    }

    private boolean isInvalidTicket(Ticket ticket) {
        if (isNoTicket(ticket)) {
            ticketMessage = "Please provide your parking ticket.";
            return true;
        }
        if (isWrongTicket(ticket)) {
            ticketMessage = "Unrecognized parking ticket.";
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
