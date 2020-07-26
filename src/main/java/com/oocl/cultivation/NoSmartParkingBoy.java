package com.oocl.cultivation;

import java.util.List;
import java.util.Optional;

public class NoSmartParkingBoy extends ParkingBoy {

    public NoSmartParkingBoy(List<Park> parkList) {
        super(parkList);
    }

    @Override
    public Ticket parkingCar(Car car) {
        if (isCanParkingCar(car)) {
            Optional<Park> resultPark = this.getParkList().stream().filter(park -> park.getEmptyPositionCount() != 0).findFirst();
            Park park = resultPark.get();
            Ticket ticket = new Ticket(car.getCarNumber(), car, park);
            this.getTicketList().add(ticket);
            park.setEmptyPositionCount(park.getEmptyPositionCount() - 1);
            return ticket;
        }
        return null;
    }

}
