package Parking_Lot.ParkingSpot;

import Parking_Lot.VehicleFactoryPattern.Vehicle;

public abstract class ParkingSpot {
    private final int spotNo;
    private boolean isOccupied;
    private Vehicle vehicle;
    private final String spotType;

    public ParkingSpot(int spotNo, String spotType) {
        this.spotNo = spotNo;
        this.spotType = spotType;
        this.isOccupied = false;
    }

    public abstract boolean canParkVehicle(Vehicle vehicle);

    public void parkVehicle(Vehicle vehicle) {
        if(isOccupied) {
            throw new IllegalStateException("Spot is already occupied.");
        }
        if(!canParkVehicle(vehicle)) {
            throw new IllegalArgumentException("This spot is not available for " + vehicle.getVehicleType());
        }
        this.vehicle = vehicle;
        isOccupied = true;
    }

    public void vacate() {
        if(!isOccupied) {
            throw new IllegalStateException("Spot is already vacant.");
        }
        vehicle = null;
        isOccupied = false;
    }


    public int getSpotNo() {
        return spotNo;
    }
    public boolean isOccupied() {
        return !isOccupied;
    }
    public String getSpotType() {
        return spotType;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
}
