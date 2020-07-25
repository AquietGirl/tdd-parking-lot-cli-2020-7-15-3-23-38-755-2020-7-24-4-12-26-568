package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class ParkingBoy{

    private List<Ticket> ticketList;
    private List<Park> parkList;
    private String ticketMessage;
    private String parkMessage;

    public ParkingBoy() {
        ticketList = new ArrayList<>();
        parkList = new ArrayList<>();
        parkList.add(new Park("park1"));
        parkList.add(new Park("park2"));
    }

    public void setTicketMessage(String ticketMessage) {
        this.ticketMessage = ticketMessage;
    }

    public void setParkMessage(String parkMessage) {
        this.parkMessage = parkMessage;
    }

    public String getTicketMessage() {
        return ticketMessage;
    }

    public String getParkMessage() {
        return parkMessage;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public List<Park> getParkList() {
        return parkList;
    }

    public abstract Ticket parkingCar(Car car);

    public Car fetchingCar(Ticket ticket) {
        if (isInvalidTicket(ticket)) {
            return null;
        }
        ticketList.removeIf(ticketEach -> ticketEach.getTicketNumber().equals(ticket.getTicketNumber()));
        Optional<Park> resultPark = this.getParkList().stream().filter(park -> park.getParkName().equals(ticket.getPark().getParkName())).findFirst();
        if (resultPark.isPresent()) {
            Park park = resultPark.get();
            park.setEmptyPositionCount(park.getEmptyPositionCount() + 1);
        }
        for (Park park: parkList) {
            if (ticket.getPark().getParkName().equals(park.getParkName())) {
                park.setEmptyPositionCount(park.getEmptyPositionCount() + 1);
            }
        }
        return ticket.getCar();
    }

    public boolean isCanParkingCar(Car car) {
        return car != null && !isParked(car);
    }

    private boolean isParked(Car car) {
        List<Ticket> tickets = ticketList.stream().filter(ticket -> ticket.getCar() == car).collect(Collectors.toList());
        return tickets.size() != 0;
    }


    public boolean hasCarPosition(Park park) {
        if (park.getEmptyPositionCount() == 0){
            parkMessage = "Not enough position.";
            return false;
        }
        return true;
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
