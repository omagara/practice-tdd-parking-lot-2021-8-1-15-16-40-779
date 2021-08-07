package com.parkinglot;

import java.util.List;

public class StandardParkingBoy {
    private  ParkingLot parkingLot;
    private List<ParkingLot> parkingLots;

    public StandardParkingBoy(ParkingLot parkingLot) {
        this.parkingLot=parkingLot;
    }

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public ParkingTicket park(Car car) {
        ParkingLot parkingLot = parkingLots
                .stream()
                .reduce((currentParkingLot,nextParkingLot) -> !currentParkingLot.isFullyOccupied() ? currentParkingLot : nextParkingLot)
                .get();
        return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return parkingLot.fetch(parkingTicket);
    }

}
