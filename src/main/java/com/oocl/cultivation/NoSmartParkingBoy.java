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

}
