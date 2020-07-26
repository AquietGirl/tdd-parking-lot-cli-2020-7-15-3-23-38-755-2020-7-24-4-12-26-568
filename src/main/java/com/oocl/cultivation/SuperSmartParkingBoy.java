package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SuperSmartParkingBoy extends ParkingBoy {
    @Override
    public Ticket parkingCar(Car car) {
        if (isCanParkingCar(car)) {
            Optional<Park> parks = this.getParkList().stream().reduce((x, y) -> {
                int rateX = (x.getEmptyPositionCount() / 10);
                int rateY = (y.getEmptyPositionCount() / 10);
                return rateX > rateY ? x : y;
            });
            if (parks.isPresent()){
                Park morePositionPark = parks.get();
                Ticket ticket = new Ticket(car.getCarNumber(), car, morePositionPark);
                this.getTicketList().add(ticket);
                morePositionPark.setEmptyPositionCount(morePositionPark.getEmptyPositionCount() - 1);
                return ticket;
            }

        }
        return null;
    }
}