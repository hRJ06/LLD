package Parking_Lot;

import Parking_Lot.ParkingSpot.ParkingSpot;
import Parking_Lot.VehicleFactoryPattern.Vehicle;

import java.util.List;

public class ParkingLot {
    private final List<ParkingSpot> parkingSpotList;

    public ParkingLot(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    public ParkingSpot findAvailableSpot(String vehicleType) {
        for(ParkingSpot spot : parkingSpotList) {
            if(spot.isOccupied() && spot.getSpotType().equals(vehicleType)) {
                return spot;
            }
        }
        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findAvailableSpot(vehicle.getVehicleType());
        if(spot != null) {
            spot.parkVehicle(vehicle);
            System.out.println("Vehicle parked successfully in Spot - " + spot.getSpotNo());
            return spot;
        }
        System.out.println("No parking spot available for " + vehicle.getVehicleType() + "!");
        return null;
    }

    public void vacateSpot(ParkingSpot spot, Vehicle vehicle) {
           if(spot != null && spot.isOccupied() && spot.getVehicle().equals(vehicle)) {
               spot.vacate();
               System.out.println(vehicle.getVehicleType() + " vacated the spot - " + spot.getSpotNo());
           }
    }
}
