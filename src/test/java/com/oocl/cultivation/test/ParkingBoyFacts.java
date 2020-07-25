package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParkingBoyFacts {
    /*
     Given  1car 1boy
     When  boy parking car
     Then  return ticket
     *
     Given 1ticket 1boy
     When  boy fetch car
     Then  return car
    * */
    @Test
    void should_return_ticket_when_boy_parking_car() {
        //given
        Car car = new Car("car1");
        ParkingBoy parkingBoy = new NoSmartParkingBoy();

        //when
        Ticket actualTicket = parkingBoy.parkingCar(car);

        //then
        Assertions.assertNotNull(actualTicket);
    }


    @Test
    void should_return_car_when_boy_fetching_car() {
        //given
        ParkingBoy parkingBoy = new NoSmartParkingBoy();
        Ticket ticket = new Ticket("car1", new Car("car1"), new Park("park1"));
        parkingBoy.parkingCar(new Car("car1"));

        //when
        Car actualCar = parkingBoy.fetchingCar(ticket);

        //then
        Assertions.assertNotNull(actualCar);
    }

    /*
     * Given  ticket boy
     * When  boy fetching car
     * Then  correspond car
     * */
    @Test
    void should_return_correspond_when_boy_fetching_car() {
        //given
        ParkingBoy parkingBoy = new NoSmartParkingBoy();
        Car car = new Car("car1");
        Ticket ticket = parkingBoy.parkingCar(car);

        //when
        Car actualCar = parkingBoy.fetchingCar(ticket);

        //then
        Assertions.assertEquals(car.getCarNumber(), actualCar.getCarNumber());
    }

    /*
     * Given  wrong ticket boy
     * When   boy fetching car
     * Then   null car
     *
     * Given  no ticket boy
     * When  boy fetching car
     * Then  null car
     * */
    @Test
    void should_return_null_when_boy_fetching_car_given_wrong_ticket() {
        //given
        ParkingBoy parkingBoy = new NoSmartParkingBoy();
        Ticket ticket = new Ticket("2", new Car("car1"), new Park("park1"));
        parkingBoy.parkingCar(new Car("car1"));

        //when
        Car actualCar = parkingBoy.fetchingCar(ticket);

        //then
        Assertions.assertNull(actualCar);
    }

    @Test
    void should_return_null_when_boy_fetching_car_given_no_ticket() {
        //given
        ParkingBoy parkingBoy = new NoSmartParkingBoy();
        Ticket ticket = null;

        //when
        Car actualCar = parkingBoy.fetchingCar(ticket);

        //then
        Assertions.assertNull(actualCar);
    }


    /*
     * Given  used ticket boy
     * When  boy fetching car
     * Then  null car
     * */
    @Test
    void should_return_null_when_boy_fetching_car_given_used_ticket() {
        //given
        ParkingBoy parkingBoy =new NoSmartParkingBoy();
        Car car = new Car("car1");
        Ticket ticket = parkingBoy.parkingCar(car);
        parkingBoy.fetchingCar(ticket);

        //when
        Car actualCar = parkingBoy.fetchingCar(ticket);

        //then
        Assertions.assertNull(actualCar);
    }

    /*
     * Given car boy
     * When boy parking car but parking is no position
     * Then null ticket
     * */
    @Test
    void should_return_null_when_boy_parking_car_but_no_position() {
        //given
        ParkingBoy parkingBoy = new NoSmartParkingBoy();
        Car car = new Car("car1");
        parkingBoy.getParkList().forEach(park -> park.setEmptyPositionCount(0));

        //when
        Ticket ticket = parkingBoy.parkingCar(car);

        //then
        Assertions.assertNull(ticket);
    }

    /*
     * Given  car in parking boy
     * When   boy parking car
     * Then   null ticket
     * */
    @Test
    void should_return_null_when_boy_parking_parked_car() {
        //given
        ParkingBoy parkingBoy = new NoSmartParkingBoy();
        Car car = new Car("car1");
        parkingBoy.parkingCar(car);

        //when
        Ticket ticket = parkingBoy.parkingCar(car);

        //then
        Assertions.assertNull(ticket);
    }

    /*
     * Given  null car
     * When  boy parking car
     * Then  null ticket
     * */
    @Test
    void should_return_null_when_boy_parking_null_car() {
        //given
        ParkingBoy parkingBoy = new NoSmartParkingBoy();
        Car car = null;

        //when
        Ticket ticket = parkingBoy.parkingCar(car);

        //then
        Assertions.assertNull(ticket);
    }

    /*
     * Given  wrong ticket
     * When  boy fetching car
     * Then  return "Unrecognized parking ticket."
     * */
    @Test
    void should_return_unrecognized_parking_ticket_when_boy_fetching_car_given_wrong_ticket() {
        //given
        ParkingBoy parkingBoy = new NoSmartParkingBoy();
        Ticket ticket = new Ticket("2", new Car("car1"), new Park("park1"));
        parkingBoy.fetchingCar(ticket);

        //when
        String message = parkingBoy.getTicketMessage();

        //then
        Assertions.assertEquals("Unrecognized parking ticket.", message);
    }


    /*
     * Given  no ticket boy
     * When  boy fetching car
     * Then  return "Please provide your parking ticket."
     * */
    @Test
    void should_return_please_provide_your_parking_ticket_when_boy_fetching_car_given_no_ticket() {
        //given
        ParkingBoy parkingBoy = new NoSmartParkingBoy();
        Ticket ticket = null;
        parkingBoy.fetchingCar(ticket);

        //when
        String message = parkingBoy.getTicketMessage();

        //then
        Assertions.assertEquals("Please provide your parking ticket.", message);
    }

    /*
     * Given  car
     * When  boy parking car but no position
     * Then  return "Not enough position."
     * */
    @Test
    void should_return_not_enough_position_when_boy_parking_car_but_not_position_given_car() {
        //given
        ParkingBoy parkingBoy = new NoSmartParkingBoy();
        parkingBoy.getParkList().forEach(park -> park.setEmptyPositionCount(0));
        parkingBoy.parkingCar(new Car("car1"));

        //when
        String message = parkingBoy.getParkMessage();

        //then
        Assertions.assertEquals("Not enough position.", message);
    }

    /*
     * Given  car
     * When  boy parking car but park1 is full
     * Then  parking car to park2
     * */
    @Test
    void should_return_car_in_park2_when_boy_parking_car_but_park1_is_full_given_car() {
        //given
        ParkingBoy parkingBoy = new NoSmartParkingBoy();
        Car car = new Car("car1");
        parkingBoy.getParkList().get(0).setEmptyPositionCount(0);

        //when
        Ticket ticket = parkingBoy.parkingCar(car);

        //then
        Assertions.assertEquals("park2", ticket.getPark().getParkName());
    }

    /*
    * Given  car
    * When  boy parking car in park which have more position
    * Then  car is in park that more position
    * */
    @Test
    void should_return_car_in_park_that_have_more_position_when_boy_parking_car_given_car() {
        //given
        ParkingBoy smartParkingBoy = new SmartParkingBoy();
        Car car = new Car("car1");
        smartParkingBoy.getParkList().get(0).setEmptyPositionCount(6);
        smartParkingBoy.getParkList().get(1).setEmptyPositionCount(5);

        //when
        Ticket ticket = smartParkingBoy.parkingCar(car);

        //then
        Assertions.assertEquals("park1", ticket.getPark().getParkName());
    }
}
