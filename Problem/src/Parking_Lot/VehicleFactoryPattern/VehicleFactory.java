package Parking_Lot.VehicleFactoryPattern;

import Parking_Lot.FareStrategyPattern.ParkingFeeStrategy;
import Parking_Lot.VehicleFactoryPattern.ConcreteVehicle.BikeVehicle;
import Parking_Lot.VehicleFactoryPattern.ConcreteVehicle.CarVehicle;

public class VehicleFactory {
    public static Vehicle createVehicle(String vehicleType, String licensePlate, ParkingFeeStrategy parkingFeeStrategy) {
        if(vehicleType.equals("Car")) {
            return new CarVehicle(licensePlate, vehicleType, parkingFeeStrategy);
        }
        return new BikeVehicle(licensePlate, vehicleType, parkingFeeStrategy);
    }
}
