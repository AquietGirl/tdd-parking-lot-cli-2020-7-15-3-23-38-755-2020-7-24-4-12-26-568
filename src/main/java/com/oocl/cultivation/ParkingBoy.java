package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class ParkingBoy {

    private List<Ticket> ticketList;
    private List<Park> parkList;
    private String ticketMessage;
    private String parkMessage;

    public ParkingBoy(List<Park> parkList) {
        ticketList = new ArrayList<>();
        this.parkList = parkList;
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

    public abstract Park choosePark(Car car);

    public Ticket parkingCar(Car car) {
        Park park = choosePark(car);
        if (park != null) {
            Ticket ticket = new Ticket(car.getCarNumber(), car, park);
            this.getTicketList().add(ticket);
            park.setEmptyPositionCount(park.getEmptyPositionCount() - 1);
            return ticket;
        }
        return null;
    }

    ;

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
        for (Park park : parkList) {
            if (ticket.getPark().getParkName().equals(park.getParkName())) {
                park.setEmptyPositionCount(park.getEmptyPositionCount() + 1);
            }
        }
        return ticket.getCar();
    }

    public boolean isCanParkingCar(Car car) {
        return car != null && !isParked(car) && hasCarPosition();
    }

    private boolean isParked(Car car) {
        List<Ticket> tickets = ticketList.stream().filter(ticket -> ticket.getCar() == car).collect(Collectors.toList());
        return tickets.size() != 0;
    }

    private boolean hasCarPosition() {
        List<Park> parks = parkList.stream().filter(park -> park.getEmptyPositionCount() != 0).collect(Collectors.toList());
        if (!parks.isEmpty()) {
            return true;
        }
        parkMessage = "Not enough position.";
        return false;
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
