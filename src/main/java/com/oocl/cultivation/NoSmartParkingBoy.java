package com.oocl.cultivation;

import java.util.Optional;

public class NoSmartParkingBoy extends ParkingBoy{
    @Override
    public Ticket parkingCar(Car car) {
        if (isCanParkingCar(car)) {
            Optional<Park> resultPark = this.getParkList().stream().filter(this::hasCarPosition).findFirst();
            if (resultPark.isPresent()) {
                Park park = resultPark.get();
                Ticket ticket = new Ticket(car.getCarNumber(), car, park);
                this.getTicketList().add(ticket);
                park.setEmptyPositionCount(park.getEmptyPositionCount() - 1);
                return ticket;
            }
        }
        return null;
    }

    @Override
    public Car fetchingCar(Ticket ticket) {
        if (isInvalidTicket(ticket)) {
            return null;
        }
        this.getTicketList().removeIf(ticketEach -> ticketEach.getTicketNumber().equals(ticket.getTicketNumber()));
        Optional<Park> resultPark = this.getParkList().stream().filter(park -> park.getParkName().equals(ticket.getPark().getParkName())).findFirst();
        if (resultPark.isPresent()) {
            Park park = resultPark.get();
            park.setEmptyPositionCount(park.getEmptyPositionCount() + 1);
        }
        for (Park park: this.getParkList()) {
            if (ticket.getPark().getParkName().equals(park.getParkName())) {
                park.setEmptyPositionCount(park.getEmptyPositionCount() + 1);
            }
        }
        return ticket.getCar();
    }



}
