package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<ParkingTicket, Car> parkedPosition = new HashMap<>();
    private final int DEFAULT_PARKING_CAPACITY = 10;
    private int parkingCapacity;
    public ParkingLot(int parkingCapacity) {
        this.parkingCapacity=parkingCapacity;
    }

    public ParkingLot() {

    }


    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        if (parkingCapacity <= parkedPosition.size()){
            return null;
        }
        parkedPosition.put(parkingTicket, car);
        return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        Car car = parkedPosition.get(parkingTicket);
        parkedPosition.remove(parkingTicket);
        return car;
    }
}
