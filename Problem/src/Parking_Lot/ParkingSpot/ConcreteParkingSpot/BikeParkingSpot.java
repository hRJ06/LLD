package Parking_Lot.ParkingSpot.ConcreteParkingSpot;

import Parking_Lot.ParkingSpot.ParkingSpot;
import Parking_Lot.VehicleFactoryPattern.Vehicle;

public class BikeParkingSpot extends ParkingSpot {
    public BikeParkingSpot(int spotNo, String spotType) {
        super(spotNo, spotType);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return "Bike".equals(vehicle.getVehicleType());
    }
}
