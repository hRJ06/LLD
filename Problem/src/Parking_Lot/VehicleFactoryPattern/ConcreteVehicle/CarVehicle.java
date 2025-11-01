package Parking_Lot.VehicleFactoryPattern.ConcreteVehicle;

import Parking_Lot.FareStrategyPattern.ParkingFeeStrategy;
import Parking_Lot.VehicleFactoryPattern.Vehicle;

public class CarVehicle extends Vehicle {
    public CarVehicle(String licensePlate, String vehicleType, ParkingFeeStrategy parkingFeeStrategy) {
        super(licensePlate, vehicleType, parkingFeeStrategy);
    }
}
