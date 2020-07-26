package com.oocl.cultivation;

import java.util.List;
import java.util.Optional;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(List<Park> parkList) {
        super(parkList);
    }

    @Override
    public Park choosePark(Car car) {
        Optional<Park> parks = this.getParkList().stream().reduce((x, y) -> {
            int rateX = (x.getEmptyPositionCount() / x.getCapacity());
            int rateY = (y.getEmptyPositionCount() / y.getCapacity());
            return rateX > rateY ? x : y;
        });
        if (parks.isPresent()) {
            Park highAvailableRatePark = parks.get();
            return highAvailableRatePark;
        }
        return null;
    }

}
