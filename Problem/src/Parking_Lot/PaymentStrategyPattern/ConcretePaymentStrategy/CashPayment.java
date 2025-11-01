package Parking_Lot.PaymentStrategyPattern.ConcretePaymentStrategy;

import Parking_Lot.PaymentStrategyPattern.PaymentStrategy;

public class CashPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Cash payment of $" + amount);
    }
}
