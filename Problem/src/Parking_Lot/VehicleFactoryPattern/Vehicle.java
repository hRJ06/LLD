package Parking_Lot.VehicleFactoryPattern;

import Parking_Lot.DurationType;
import Parking_Lot.FareStrategyPattern.ParkingFeeStrategy;

public abstract class Vehicle {
    private final String licensePlate;
    private final String vehicleType;
    private final ParkingFeeStrategy parkingFeeStrategy;

    public Vehicle(String licensePlate, String vehicleType, ParkingFeeStrategy parkingFeeStrategy) {
        this.vehicleType = vehicleType;
        this.licensePlate = licensePlate;
        this.parkingFeeStrategy = parkingFeeStrategy;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public double calculateFee(int duration, DurationType durationType) {
        return parkingFeeStrategy.calculateFee(vehicleType, duration, durationType);
    }
}
