package OCP;

public class CreditCard implements PaymentMethod{
    @Override
    public void pay(double amount) {
        System.out.println("Credit Card payment - " + amount);
    }
}
