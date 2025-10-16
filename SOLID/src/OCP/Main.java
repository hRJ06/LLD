package OCP;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        PaymentMethod creditCard = new CreditCard();
        paymentProcessor.processPayment(creditCard, 200);

        PaymentMethod upi = new UPI();
        paymentProcessor.processPayment(upi, 100);
    }
}
