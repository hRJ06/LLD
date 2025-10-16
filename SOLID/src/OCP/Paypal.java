package OCP;

public class Paypal implements PaymentMethod{
    @Override
    public void pay(double amount) {
        System.out.println("Paypal payment - " + amount);
    }
}
