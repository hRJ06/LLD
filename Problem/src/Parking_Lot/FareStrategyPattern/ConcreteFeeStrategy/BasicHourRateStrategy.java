package Parking_Lot.FareStrategyPattern.ConcreteFeeStrategy;

import Parking_Lot.DurationType;
import Parking_Lot.FareStrategyPattern.ParkingFeeStrategy;

public class BasicHourRateStrategy implements ParkingFeeStrategy {
    @Override
    public double calculateFee(String vehicleType, int duration, DurationType type) {
        return switch (vehicleType.toLowerCase()) {
            case "car" -> type != DurationType.HOURS
                    ? duration * 10.0 * 24
                    : duration * 10.0;

            case "bike" -> type != DurationType.HOURS
                    ? duration * 5.0 * 24
                    : duration * 5.0;

            case "auto" -> type != DurationType.HOURS
                    ? duration * 8.0 * 24
                    : duration * 8.0;

            default -> type != DurationType.HOURS
                    ? duration * 15.0 * 24
                    : duration * 15.0;
        };
    }
}
