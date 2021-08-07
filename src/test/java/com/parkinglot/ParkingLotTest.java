package com.parkinglot;

import com.parkinglot.exceptions.NoAvailablePositionException;
import com.parkinglot.exceptions.UnrecognizedParkingTicketException;
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

    @Test
    void should_return_nothing_when_fetch_given_a_parking_lot_and_used_parking_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);
        Car firstActualCar = parkingLot.fetch(parkingTicket);

        //when
        Car secondActualCar = parkingLot.fetch(parkingTicket);

        //then
        assertEquals(car, firstActualCar);
        assertNull(secondActualCar);
    }

    @Test
    void should_return_nothing_when_park_given_a_parking_lot_without_space_and_a_car(){
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car firstCar = new Car();
        parkingLot.park(firstCar);
        Car secondCar = new Car();

        //when
        ParkingTicket parkingTicket = parkingLot.park(secondCar);

        //then
        assertNull(parkingTicket);
    }

    @Test
    void should_return_nothing_with_error_message_unrecognized_parking_ticket_when_fetch_given_a_parking_lot_and_an_unrecoginized_ticket (){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket wrongParkingTicket = new ParkingTicket();

        //when
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.fetch(wrongParkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_return_nothing_with_error_message_no_available_position_when_park_given_a_parking_lot_without_any_position(){
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


}
