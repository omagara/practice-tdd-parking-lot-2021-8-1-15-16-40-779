package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Car car;
    private Map<ParkingTicket, Car> parkedPosition = new HashMap<>();

    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        parkedPosition.put(parkingTicket, car);
        return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        Car car = parkedPosition.get(parkingTicket);
        parkedPosition.remove(parkingTicket);
        return car;
    }
}
