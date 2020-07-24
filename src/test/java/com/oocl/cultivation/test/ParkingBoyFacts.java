package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingBoyFacts {
    @Test
    void should_return_ticket_when_boy_parking_car() {
        //given
        Car car = new Car("car1");
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket expectTicket = new Ticket(1);

        //when
        Ticket actualTicket = parkingBoy.parkingCar(car);

        //then
        Assertions.assertEquals(expectTicket, actualTicket);
    }


    @Test
    void should_car_when_boy_ferching_car() {
        //given
        Car expectCar = new Car("car1");
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket(1);

        //when
        Car actualCar = parkingBoy.fetchingCar(ticket);

        //then
        Assertions.assertEquals(expectCar, actualCar);
    }
}
