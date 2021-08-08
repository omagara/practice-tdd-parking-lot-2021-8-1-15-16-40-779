package com.parkinglot;

import com.parkinglot.exceptions.NoAvailablePositionException;
import com.parkinglot.exceptions.UnrecognizedParkingTicketException;

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
        parkingCapacity = DEFAULT_PARKING_CAPACITY;
    }

    public int getCurrentCapacity() {
        return parkingCapacity - parkedPosition.size();
    }

    public Map<ParkingTicket, Car> getParkedPosition() {
        return parkedPosition;
    }

    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        if (isFullyOccupied()){
            throw new NoAvailablePositionException();
        }
        parkedPosition.put(parkingTicket, car);
        return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (!isValidParkingTicket(parkingTicket)) {
            throw new UnrecognizedParkingTicketException();
        }
        Car car = parkedPosition.get(parkingTicket);
        parkedPosition.remove(parkingTicket);
        return car;
    }

    public boolean isValidParkingTicket(ParkingTicket parkingTicket){
        return parkedPosition.containsKey(parkingTicket);
    }

    public boolean isFullyOccupied(){
        return parkingCapacity == parkedPosition.size();
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "parkedPosition=" + parkedPosition +
                ", DEFAULT_PARKING_CAPACITY=" + DEFAULT_PARKING_CAPACITY +
                ", parkingCapacity=" + parkingCapacity +
                '}';
    }
}
