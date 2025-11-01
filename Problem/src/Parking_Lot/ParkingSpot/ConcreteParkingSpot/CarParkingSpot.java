package Parking_Lot.ParkingSpot.ConcreteParkingSpot;

import Parking_Lot.ParkingSpot.ParkingSpot;
import Parking_Lot.VehicleFactoryPattern.Vehicle;

public class CarParkingSpot extends ParkingSpot {
    public CarParkingSpot(int spotNo, String spotType) {
        super(spotNo, spotType);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return "Car".equals(vehicle.getVehicleType());
    }
}
