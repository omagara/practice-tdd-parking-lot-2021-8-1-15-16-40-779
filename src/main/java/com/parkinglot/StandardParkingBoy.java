package com.parkinglot;

public class StandardParkingBoy {
    private  ParkingLot parkingLot;

    public StandardParkingBoy(ParkingLot parkingLot) {
        this.parkingLot=parkingLot;
    }

    public ParkingTicket park(Car car) {
    return parkingLot.park(car);
    }
}
