package Parking_Lot.VehicleFactoryPattern.ConcreteVehicle;

import Parking_Lot.FareStrategyPattern.ParkingFeeStrategy;
import Parking_Lot.VehicleFactoryPattern.Vehicle;

public class BikeVehicle extends Vehicle {
    public BikeVehicle(String licensePlate, String vehicleType, ParkingFeeStrategy parkingFeeStrategy) {
        super(licensePlate, vehicleType, parkingFeeStrategy);
    }
}
