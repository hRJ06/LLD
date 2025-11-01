package Parking_Lot.PaymentStrategyPattern.ConcretePaymentStrategy;

import Parking_Lot.PaymentStrategyPattern.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card payment of $" + amount);
    }
}
