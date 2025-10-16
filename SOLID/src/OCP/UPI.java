package OCP;

public class UPI implements PaymentMethod{
    @Override
    public void pay(double amount) {
        System.out.println("UPI payment - " + amount);
    }
}
