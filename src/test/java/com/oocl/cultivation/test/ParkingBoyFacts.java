package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingBoyFacts {
    @Test
    void should_return_ticket_when_boy_parking_car() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        String ticket = parkingBoy.parkingCar(car);

        //then
        Assertions.assertEquals("ticket", ticket);
    }
}
