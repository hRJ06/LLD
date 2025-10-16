package Strategy_Design_Pattern;

public class CreditCardPaymentStrategy implements PaymentStrategy{
    @Override
    public void processPayment(float amount) {
        System.out.println("Credit Card Payment - " + amount);
    }
}
