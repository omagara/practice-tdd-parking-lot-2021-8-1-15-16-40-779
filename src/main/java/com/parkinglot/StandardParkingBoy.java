package com.parkinglot;

import com.parkinglot.exceptions.UnrecognizedParkingTicketException;

import java.util.List;
import java.util.Objects;

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

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public ParkingTicket park(Car car) {
        if(parkingLots!=null){
            if (!parkingLots.get(0).isFullyOccupied()) {
                return parkingLots.get(0).park(car);
            }
            if (parkingLots.get(0).isFullyOccupied()){
                return parkingLots.get(1).park(car);
            }
        }
        return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (!Objects.isNull(parkingLot)) {
            return parkingLot.fetch(parkingTicket);
        }
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isValidParkingTicket(parkingTicket)) {
                return parkingLot.fetch(parkingTicket);
            }
        }
        throw new UnrecognizedParkingTicketException();

    }

}
