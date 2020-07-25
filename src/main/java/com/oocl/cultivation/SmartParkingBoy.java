package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SmartParkingBoy extends ParkingBoy {
    @Override
    public Ticket parkingCar(Car car) {
       if (isCanParkingCar(car)) {
            List<Park> parks = this.getParkList().stream().sorted(Comparator.comparing(Park::getEmptyPositionCount).reversed()).collect(Collectors.toList());
            Park morePositionPark = parks.get(0);
            Ticket ticket = new Ticket(car.getCarNumber(), car, morePositionPark);
            this.getTicketList().add(ticket);
            morePositionPark.setEmptyPositionCount(morePositionPark.getEmptyPositionCount() - 1);
            return ticket;
        }
        return null;
    }

}
