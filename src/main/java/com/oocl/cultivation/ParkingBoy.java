package com.oocl.cultivation;

public class ParkingBoy {

    public Ticket parkingCar(Car car) {
        return new Ticket("1", car);
    }

    public Car fetchingCar(Ticket ticket) {
        if (isInvalidTicket()) {
            return null;
        }
        return new Car("car1");
    }

    private boolean isInvalidTicket() {
        return true;
    }
}
