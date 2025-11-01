package Parking_Lot;

import Parking_Lot.FareStrategyPattern.ConcreteFeeStrategy.BasicHourRateStrategy;
import Parking_Lot.FareStrategyPattern.ConcreteFeeStrategy.PremiumRateStrategy;
import Parking_Lot.FareStrategyPattern.ParkingFeeStrategy;
import Parking_Lot.ParkingSpot.ConcreteParkingSpot.BikeParkingSpot;
import Parking_Lot.ParkingSpot.ConcreteParkingSpot.CarParkingSpot;
import Parking_Lot.ParkingSpot.ParkingSpot;
import Parking_Lot.PaymentStrategyPattern.ConcretePaymentStrategy.CashPayment;
import Parking_Lot.PaymentStrategyPattern.ConcretePaymentStrategy.CreditCardPayment;
import Parking_Lot.PaymentStrategyPattern.PaymentStrategy;
import Parking_Lot.VehicleFactoryPattern.Vehicle;
import Parking_Lot.VehicleFactoryPattern.VehicleFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.add(new CarParkingSpot(1, "Car"));
        parkingSpots.add(new CarParkingSpot(2,"Car"));
        parkingSpots.add(new BikeParkingSpot(3, "Bike"));
        parkingSpots.add(new BikeParkingSpot(4, "Bike"));

        ParkingLot parkingLot = new ParkingLot(parkingSpots);

        ParkingFeeStrategy basicHourRateStrategy = new BasicHourRateStrategy();
        ParkingFeeStrategy premiumRateStrategy = new PremiumRateStrategy();

        Vehicle car1 = VehicleFactory.createVehicle("Car", "CAR123", basicHourRateStrategy);
        Vehicle car2 = VehicleFactory.createVehicle("Car", "CAR345", basicHourRateStrategy);

        Vehicle bike1 = VehicleFactory.createVehicle("Bike", "BIKE456", premiumRateStrategy);
        Vehicle bike2 = VehicleFactory.createVehicle("Bike", "BIKE123", premiumRateStrategy);

        ParkingSpot carSpot = parkingLot.parkVehicle(car1);
        ParkingSpot bikeSpot = parkingLot.parkVehicle(bike1);

        ParkingSpot carSpot2 = parkingLot.parkVehicle(car2);
        ParkingSpot bikeSpot2 = parkingLot.parkVehicle(bike2);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select payment method for your vehicle - ");
        System.out.println("1. Credit Card");
        System.out.println("2. Cash");
        int paymentMethod = scanner.nextInt();

        if(carSpot != null) {
            double carFee = car1.calculateFee(2, DurationType.HOURS);
            PaymentStrategy carPaymentStrategy = getPaymentStrategy(paymentMethod);
            carPaymentStrategy.processPayment(carFee);
            parkingLot.vacateSpot(carSpot, car1);
        }

        if(bikeSpot != null) {
            double bikeFee = bike1.calculateFee(3, DurationType.HOURS);
            PaymentStrategy bikePaymentStrategy = getPaymentStrategy(paymentMethod);
            bikePaymentStrategy.processPayment(bikeFee);
            parkingLot.vacateSpot(bikeSpot, bike1);
        }

        scanner.close();
    }

    private static PaymentStrategy getPaymentStrategy(int paymentMethod) {
        switch (paymentMethod) {
            case 1 -> {
                return new CreditCardPayment();
            }
            case 2 -> {
                return new CashPayment();
            }
            default -> {
                System.out.println("Invalid choice! Default to Credit Card payment.");
                return new CreditCardPayment();
            }
        }
    }
}
