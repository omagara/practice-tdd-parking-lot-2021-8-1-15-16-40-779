package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
