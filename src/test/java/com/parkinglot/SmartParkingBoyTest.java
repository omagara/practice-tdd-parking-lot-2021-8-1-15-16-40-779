package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SmartParkingBoyTest {

    @Test
    void should_parked_to_the_first_parking_lot_when_park_given_two_available_parking_lots_a_smart_parking_boy_and_a_car(){
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());

        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        //when
        ParkingTicket parkingTicket = smartParkingBoy.park(car);

        //then
        assertNotNull(smartParkingBoy.getParkingLots().get(0));

    }

    @Test
    void should_parked_to_the_second_parking_lot_when_park_given_two_parking_lots_second_parking_lot_has_more_available_space_than_first_parking_lot_a_smart_parking_boy_and_a_car(){
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot firstParkingLot = new ParkingLot(3);
        ParkingLot secondParkingLot = new ParkingLot(5);
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        smartParkingBoy.park(new Car());
        smartParkingBoy.park(new Car());

        //when
        smartParkingBoy.park(new Car());

        //then
        assertEquals(secondParkingLot, smartParkingBoy.getAvailableParkingLot());

    }

    @Test
    void should_parked_to_the_first_parking_lot_when_park_given_two_parking_lots_first_parking_lot_has_more_available_space_than_second_parking_lot_a_smart_parking_boy_and_a_car(){
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        smartParkingBoy.park(new Car());
        smartParkingBoy.park(new Car());

        //when
        smartParkingBoy.park(new Car());

        //then
        assertEquals(firstParkingLot, smartParkingBoy.getParkingLot());

    }

}
