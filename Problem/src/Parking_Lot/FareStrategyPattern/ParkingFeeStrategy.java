package Parking_Lot.FareStrategyPattern;

import Parking_Lot.DurationType;

public interface ParkingFeeStrategy {
    double calculateFee(String vehicleType, int duration, DurationType type);
}
