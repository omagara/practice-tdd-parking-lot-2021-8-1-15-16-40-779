package com.parkinglot;

import com.parkinglot.exceptions.NoAvailablePositionException;
import com.parkinglot.exceptions.UnrecognizedParkingTicketException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StandardParkingBoyTest {
    @Test
    void should_return_the_parking_ticket_when_park_given_a_parking_lot_a_standard_parking_boy_and_a_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);

        //when
        ParkingTicket parkingTicket = standardParkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_the_car_when_fetch_given_a_parking_lot_a_standard_parking_boy_and_a_parking_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        ParkingTicket parkingTicket = standardParkingBoy.park(car);

        //when
        Car actualCar = standardParkingBoy.fetch(parkingTicket);

        //then
        assertEquals(car, actualCar);
    }

    @Test
    void should_return_the_right_car_with_each_ticket_when_fetch_car_twice_given_a_parking_lot_with_two_parked_cars_a_standard_parking_boy_and_two_parked_tickets(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car hisCar = new Car();
        Car herCar = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        ParkingTicket hisParkingTicket = standardParkingBoy.park(hisCar);
        ParkingTicket herParkingTicket = standardParkingBoy.park(herCar);

        //when
        Car hisActualCar = standardParkingBoy.fetch(hisParkingTicket);
        Car herActualCar = standardParkingBoy.fetch(herParkingTicket);

        //then
        assertEquals(hisCar, hisActualCar);
        assertEquals(herCar, herActualCar);
    }

    @Test
    void should_return_nothing_with_error_message_unrecognized_parking_ticket_when_fetch_given_a_parking_lot_a_standard_parking_boy_and_an_unrecoginized_ticket (){
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        ParkingTicket wrongParkingTicket = new ParkingTicket();

        //when
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> standardParkingBoy.fetch(wrongParkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_return_nothing_with_error_message_unrecognized_parking_ticket_when_fetch_given_a_parking_lot_a_standard_parking_boy_and_a_used_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = standardParkingBoy.park(car);
        Car firstActualCar = standardParkingBoy.fetch(parkingTicket);

        //when
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () ->standardParkingBoy.fetch(parkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_return_nothing_with_error_message_no_available_position_when_park_given_a_parking_lot_without_any_position_and_standard_parking_boy(){
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car firstCar = new Car();
        parkingLot.park(firstCar);
        Car secondCar = new Car();

        //when
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> parkingLot.park(secondCar));

        //then
        assertEquals("No available position.", exception.getMessage());
    }

    @Test
    void should_parked_the_car_to_the_first_parking_lot_when_park_given_two_available_parking_lots_a_standard_parking_boy_and_a_car(){
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());

        Car car = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);

        //when
        ParkingTicket parkingTicket = standardParkingBoy.park(car);

        //then
        assertNotNull(standardParkingBoy.getParkingLots().get(0));
    }

    @Test
    void should_be_parked_to_the_second_parking_lot_when_park_given_two_parking_lots_first_is_occupied_second_is_available_a_standard_parking_boy_and_a_car(){
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        parkingLots.add(new ParkingLot());

        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car firstCar = new Car();
        standardParkingBoy.park(firstCar);
        Car secondCar = new Car();

        //when
        standardParkingBoy.park(secondCar);

        //then
        assertNotNull(standardParkingBoy.getParkingLots().get(1));
    }

    @Test
    void should_return_the_right_car_with_each_ticket_when_fetch_car_twice_given_two_parking_lots_with_two_parked_cars_a_standard_parking_boy_and_two_parked_tickets(){
        //given

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);

        Car hisCar = new Car();
        Car herCar = new Car();

        ParkingTicket hisParkingTicket = standardParkingBoy.park(hisCar);
        ParkingTicket herParkingTicket = standardParkingBoy.park(herCar);

        //when
        Car hisActualCar = standardParkingBoy.fetch(hisParkingTicket);
        Car herActualCar = standardParkingBoy.fetch(herParkingTicket);

        //then
        assertEquals(hisCar, hisActualCar);
        assertEquals(herCar, herActualCar);
    }
}
