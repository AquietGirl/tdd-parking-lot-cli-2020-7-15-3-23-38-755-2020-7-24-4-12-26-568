package com.oocl.cultivation;

import java.util.List;
import java.util.Optional;

public class NoSmartParkingBoy extends ParkingBoy {

    public NoSmartParkingBoy(List<Park> parkList) {
        super(parkList);
    }

    @Override
    public Park choosePark(Car car) {
        Optional<Park> resultPark = this.getParkList().stream().filter(park -> park.getEmptyPositionCount() != 0).findFirst();
        if (resultPark.isPresent()) {
            Park firstHavePositionPark = resultPark.get();
            return firstHavePositionPark;
        }
        return null;
    }

}
