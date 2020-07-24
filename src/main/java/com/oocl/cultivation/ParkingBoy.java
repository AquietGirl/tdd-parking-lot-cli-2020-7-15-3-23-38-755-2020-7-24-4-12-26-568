package com.oocl.cultivation;

public class ParkingBoy {

    public Ticket parkingCar(Car car) {
        return new Ticket("1", car);
    }

    public Car fetchingCar(Ticket ticket) {
        return new Car("car1");
    }
}
