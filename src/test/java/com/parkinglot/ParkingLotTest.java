package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void should_return_the_parking_ticket_when_park_given_a_parking_lot_and_a_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        ParkingTicket parkingTicket = parkingLot.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_the_car_when_fetch_given_a_parking_lot_and_a_parking_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);

        //when
        Car actualCar = parkingLot.fetch(parkingTicket);

        //then
        assertEquals(car,actualCar);
    }

    @Test
    void should_return_the_right_car_with_each_ticket_when_fetch_car_twice_given_a_parking_lot_with_two_parked_cars_and_two_parked_tickets(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car hisCar = new Car();
        Car herCar = new Car();
        ParkingTicket hisParkingTicket = parkingLot.park(hisCar);
        ParkingTicket herParkingTicket = parkingLot.park(herCar);

        //when
        Car hisActualCar = parkingLot.fetch(hisParkingTicket);
        Car herActualCar = parkingLot.fetch(herParkingTicket);

        //then
        assertEquals(hisCar, hisActualCar);
        assertEquals(herCar, herActualCar);
    }

    @Test
    void should_return_nothing_when_fetch_given_a_parking_lot_and_a_wrong_parking_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket wrongParkingTicket = new ParkingTicket();

        //when
        Car actualCar = parkingLot.fetch(wrongParkingTicket);

        //then
        assertNull(actualCar);
    }
}
