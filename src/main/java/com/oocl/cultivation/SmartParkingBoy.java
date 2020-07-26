package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(List<Park> parkList) {
        super(parkList);
    }

    @Override
    public Park choosePark(Car car) {
        if (isCanParkingCar(car)) {
            List<Park> parks = this.getParkList().stream().sorted(Comparator.comparing(Park::getEmptyPositionCount).reversed()).collect(Collectors.toList());
            Park morePositionPark = parks.get(0);
            return morePositionPark;
        }
        return null;
    }

}
