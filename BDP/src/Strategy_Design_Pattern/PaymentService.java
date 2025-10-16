package Strategy_Design_Pattern;

public class PaymentService {
    public PaymentStrategy strategy;
    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    public void pay(float amount) {
        strategy.processPayment(amount);
    }
}
