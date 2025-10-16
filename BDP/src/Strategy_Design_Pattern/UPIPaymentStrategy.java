package Strategy_Design_Pattern;

public class UPIPaymentStrategy implements PaymentStrategy{
    @Override
    public void processPayment(float amount) {
        System.out.println("UPI Payment - " + amount);
    }
}
