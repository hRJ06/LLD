package Strategy_Design_Pattern;

public class PaymentApplication {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        PaymentStrategy UPI = new UPIPaymentStrategy();
        service.setStrategy(UPI);
        service.pay(1000);

        PaymentStrategy CC = new CreditCardPaymentStrategy();
        service.setStrategy(CC);
        service.pay(2000);
    }
}
