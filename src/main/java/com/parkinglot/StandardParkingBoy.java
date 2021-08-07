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
        if(parkingLots!=null) {
            for (ParkingLot parkingLot : parkingLots) {
                if (parkingLot.getParkedPosition().containsKey(parkingTicket)) {
                    return parkingLot.fetch(parkingTicket);
                }
            }
        }
        return parkingLot.fetch(parkingTicket);
    }

}
